package org.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {

    @Inject
    @ConfigProperty(name="myprj.some.dynamic.timeout", defaultValue="100")
    private javax.inject.Provider<Long> timeout;
    
    @GET
    public Response ping() {
        return Response.ok("Application deployed successfully" + timeout.get()).build();
    }
}
