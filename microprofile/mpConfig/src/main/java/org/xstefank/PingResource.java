package org.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
@ApplicationScoped
public class PingResource {
    
    @Inject
    @ConfigProperty(name = "test-prop", defaultValue = "none")
    private String testProp;
    
    @Inject
    @ConfigProperty(name = "avenger")
    private Avenger avenger;
    
//    @Inject
//    @ConfigProperty(name = "avengers")
//    private List<Avenger> avengers;
    
    @GET
    public Response ping() {
        return Response.ok("Application running successfully - " + avenger).build();
    }
}
