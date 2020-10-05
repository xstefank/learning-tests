package io.xstefank;

import io.smallrye.health.api.HealthRegistry;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
@ApplicationScoped
public class PingResource {

    @Inject
    @Liveness
    HealthRegistry livenessHealthRegistry;

    @Inject
    @Readiness
    HealthRegistry readinessHealthRegistry;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/register")
    public void register() {
        livenessHealthRegistry.register(new TestLiveness());
    }

    @GET
    @Path("/remove")
    public void remove() {
        livenessHealthRegistry.remove(TestLiveness.class.getName());
    }

    @GET
    @Path("/registerReady")
    public void registerReady() {
        readinessHealthRegistry.register(new TestLiveness());
    }

    @GET
    @Path("/removeReady")
    public void removeReady() {
        readinessHealthRegistry.remove(TestLiveness.class.getName());
    }
}
