package org.xstefank;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
@RegisterLRAParticipant
public class PingResource {
    
    @GET
    public Response ping() {
        return Response.ok("Application running successfully").build();
    }

    @Inject
    TestRegistry testRegistry;
    
    @GET
    @Path("asdf")
    public String asdf() {
        return testRegistry.getValue();
    }
    
}
