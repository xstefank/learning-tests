package org.learn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/res1")
public class SimpleResource1 {

    @GET
    @Path("/get")
    public Response get() {
        return Response.ok("ok get from SimpleResource1").build();
    }
    
}
