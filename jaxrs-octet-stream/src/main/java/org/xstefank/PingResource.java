package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() {
        return Response.ok("Application deployed successfully").build();
    }
    
    @GET
    @Path("octetStream")
    public Response octetStream() {
        return Response.status(Response.Status.OK).entity(Entity.text("Hello from octet-stream")).build();
    }
}
