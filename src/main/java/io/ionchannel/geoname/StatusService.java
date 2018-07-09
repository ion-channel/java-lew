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

import javax.ws.rs.*;

import javax.ws.rs.core.Response;

import java.util.HashMap;

import java.util.Map;


@Path("/v1/status")
public class StatusService {
  @GET
  @Produces("application/json")
  public Response root() {
      Map<String, String> ok = new HashMap<String, String>();
      ok.put("message", "a ok");

      return Response.status(Response.Status.OK).
              entity(ok).build();
  }
}
