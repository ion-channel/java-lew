/*
(c) Copyright Selection Pressure LLC - 2015

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

package io.ionchannel.geoname;

import com.bericotech.clavin.GeoParser;
import com.bericotech.clavin.resolver.ResolvedLocation;
import org.apache.commons.lang3.text.WordUtils;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


@Path("/v1/geo")
public class GeoNameService {
    @Context
    private HttpServletRequest request;


    private static final Logger log = Logger.getLogger(GeoNameService.class);
    private GeoParser geoParser;


    @GET
    @Produces("application/json")
    @Path("/")
    public Response root() {
        Map<String, String> notFound = new HashMap<String, String>();
        notFound.put("message", "not found");

        return Response.status(Response.Status.NOT_FOUND).
                entity(notFound).build();
    }

    @GET
    @Produces("application/json")
    @Path("getLocationsExpanded")
    public Response expandedGeocodeFromGet(@QueryParam("text") String input) {
        return getResponseForQueryString(input, true);
    }

    @GET
    @Produces("application/json")
    @Path("getLocations")
    public Response geocodeFromGet(@QueryParam("text") String input) {
        return getResponseForQueryString(input, false);
    }

    @POST
    @Produces("application/json")
    @Consumes("text/plain")
    @Path("getLocations")
    public Response geocodeFromPost(String input) {
        return getResponseForQueryString(input, false);
    }

    private String urlWithContext(){
        StringBuilder urlBuilder = new StringBuilder();

        urlBuilder.append(request.getScheme())
                .append("://")
                .append(request.getServerName());
                if(request.getServerPort() != 80 && request.getServerPort() != 443) {
                    urlBuilder.append(":")
                    .append(request.getServerPort());
                }
                if(!request.getContextPath().isEmpty()){
                    urlBuilder.append("/")
                    .append(request.getContextPath());
                }
        return urlBuilder.toString();
    }

    private ExpandedGeoData expandedDataFromResolveLocation(ResolvedLocation resolvedLocation) {
        StringBuilder urlBuilder = new StringBuilder();
        try {
            urlBuilder.append(urlWithContext())
                    .append("/getLocations?query=")
                    .append(URLEncoder.encode(resolvedLocation.getGeoname().getName(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }

        ExpandedGeoData expandedGeoData = new ExpandedGeoData(
                resolvedLocation,
                urlBuilder.toString()
        );
        return expandedGeoData;
    }

    private SimpleGeoData simpleDataFromResolveLocation(ResolvedLocation resolvedLocation) {
        StringBuilder urlBuilder = new StringBuilder();
        try {
            urlBuilder.append(urlWithContext())
                    .append("/getLocationsExpanded?query=")
                    .append(URLEncoder.encode(resolvedLocation.getGeoname().getName(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }

        SimpleGeoData simpleGeoData = new SimpleGeoData(
                resolvedLocation,
                urlBuilder.toString()
        );
        return simpleGeoData;
    }

    private Response getResponseForQueryString(String string, Boolean expand) {
        List<ResolvedLocation> resolvedLocations = getResolvedLocationsForString(string);

        if (resolvedLocations == null || resolvedLocations.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        ObjectMapper mapper = new ObjectMapper();
        List response = new ArrayList();
        if (expand) {
            for (ResolvedLocation location : resolvedLocations){
              response.add(expandedDataFromResolveLocation(location));
            }
        } else {
          for (ResolvedLocation location : resolvedLocations){
            response.add(simpleDataFromResolveLocation(location));
          }
        }

        try {
            return Response.ok().entity(mapper.writeValueAsString(response)).build();
        } catch (IOException e) {
            log.error(e);
        }

        return Response.serverError().build();
    }

    private List<ResolvedLocation> getResolvedLocationsForString(String string) {
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
