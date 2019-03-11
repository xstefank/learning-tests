package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_XML)
@Path("ping")
public class PingResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        return Response.ok("Application deployed successfully").build();
    }
}
