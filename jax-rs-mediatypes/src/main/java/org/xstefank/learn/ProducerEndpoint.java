package org.xstefank.learn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("")
public class ProducerEndpoint {
    
    @GET
    @Path("/get")
    public Response produce() {
        return Response.ok(new Activity(42, "lol"), MediaType.APPLICATION_JSON).build();
    }
}
