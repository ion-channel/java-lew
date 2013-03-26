package com.radiantblue.geoname;

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

    if(resolvedLocations.isEmpty())
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

