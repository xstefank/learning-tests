package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {
    
    @GET
    @TestApply
    public Response ping() {
        return Response.ok("Application running successfully").build();
    }

    @GET
    @Path("2")
//    @TestApply
    public Response ping2() {
        return Response.ok("Application running successfully").build();
    }
}
