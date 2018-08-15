package org.learn;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/res3")
public class SimpleResource3 {

    @GET
    @Path("/get")
    public Response get() {
        return Response.ok("ok get from SimpleResource3").build();
    }
    
}
