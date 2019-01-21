package org.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("ping")
@ApplicationScoped
public class PingResource {
    
    @Inject
    @ConfigProperty(name = "test-prop", defaultValue = "none")
    private String testProp;
    
    @Inject
    @ConfigProperty(name = "avenger", defaultValue = "Iron Man,Tony Stark,true")
    private Optional<Avenger> avenger;
    
    @Inject
    @ConfigProperty(name = "avengers")
    private List<Avenger> avengers;
    
    @GET
    public Response ping() {
        return Response.ok("Application running successfully - " + alwaysReloaded.get()).build();
    }

    @POST
    public Response changeProp(String value) {
        System.setProperty("alwaysReloadedProp", value);
        return Response.ok("value changed").build();
    }
    
    
    @Inject
    @ConfigProperty(name = "requiredProp", defaultValue = "default")
    private String required;
    
    @Inject
    @ConfigProperty(name = "optionalProp", defaultValue = "default")
    private Optional<String> optional;
    
    @Inject
    @ConfigProperty(name = "alwaysReloadedProp", defaultValue = "default")
    private Provider<String> alwaysReloaded;
}
