package org.learn;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/appResource")
@Path("/resource")
public class MyApplicationResource extends Application {

    @GET
    @Path("/get")
    public Response get() {
        return Response.ok("ok get from " + MyApplicationResource.class.getSimpleName()).build();
    }
}
