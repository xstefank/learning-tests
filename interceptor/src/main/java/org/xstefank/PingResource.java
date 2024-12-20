package org.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
@ApplicationScoped
public class PingResource {

    @Inject
    private Dummy dummy;
    
    @GET
    public Response ping() {
        return Response.ok("Application deployed successfully - " + dummy.getHello("whatever")).build();
    }
}
