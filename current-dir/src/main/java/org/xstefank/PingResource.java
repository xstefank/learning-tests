package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() {
        System.out.println("Working Directory = " +
            System.getProperty("user.dir"));
        return Response.ok("Application running successfully").build();
    }
}
