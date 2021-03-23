package io.xstefank;

import io.smallrye.health.SmallRyeHealthReporter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
@ApplicationScoped
public class PingResource {

    @Inject
    SmallRyeHealthReporter smallRyeHealthReporter;



    @GET
    public Response ping() {
        System.out.println(smallRyeHealthReporter.getHealthAsync().await().indefinitely());
        return Response.ok("Application deployed successfully").build();
    }
}
