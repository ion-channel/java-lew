/*
(c) Copyright AirGap LLC - 2014

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

package io.airgap.geoname;

import com.berico.clavin.GeoParser;
import com.berico.clavin.resolver.ResolvedLocation;
import org.apache.commons.lang3.text.WordUtils;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@Path("/")
public class GeoNameService {
  private static final Logger log = Logger.getLogger(GeoNameService.class);

  private GeoParser geoParser;


  @GET
  @Produces("application/json")
  @Path("geonames")
  public Response geocodeFromGet(@QueryParam("query") String input) {
    return getResponseForQueryString(input);
  }

  @POST
  @Produces("application/json")
  @Consumes("text/plain")
  @Path("geonames")
  public Response geocodeFromPost(String input) {
    return getResponseForQueryString(input);
  }

  private Response getResponseForQueryString(String string){
    List<ResolvedLocation> resolvedLocations = getResolvedLocationsForString(string);

    if(resolvedLocations == null || resolvedLocations.isEmpty())
      return Response.status(Response.Status.NOT_FOUND).build();

    ObjectMapper mapper = new ObjectMapper();

    try {
      return Response.ok().entity(mapper.writeValueAsString(resolvedLocations)).build();
    } catch (IOException e) {
      log.error(e);
    }

    return Response.serverError().build();
  }

  private List<ResolvedLocation> getResolvedLocationsForString(String string){
    List<ResolvedLocation> resolvedLocations = null;
    try {
      resolvedLocations = geoParser.parse(WordUtils.capitalize(string));
    } catch (IOException e) {
      log.error(e);
    } catch (org.apache.lucene.queryparser.classic.ParseException e) {
      log.error(e);
    } catch (Exception e) {
      log.error(e);
    }
    return resolvedLocations;
  }

  public GeoParser getGeoParser() {
    return geoParser;
  }

  public void setGeoParser(GeoParser geoParser) {
    this.geoParser = geoParser;
  }
}
