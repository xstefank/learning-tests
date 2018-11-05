package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource implements PingInterface {
    
    @GET
    @Path("some")
    public Response ping() {
        return Response.ok("Application deployed successfully").build();
    }
}
