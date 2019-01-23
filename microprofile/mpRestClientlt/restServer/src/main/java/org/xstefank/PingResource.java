package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {
    
    @GET
    @Path("{param}")
    public Response ping(@PathParam("param") String param) {
        if (param.equals("ok")) {
            return Response.ok("Application running successfully").build();
        } else {
            return Response.status(500).entity("error").build();
        }
    }
}
