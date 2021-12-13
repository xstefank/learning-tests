package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() {
        ClientBuilder.newClient()
            .target("http://example.com")
            .request()
            .get();
        return Response.ok("Application deployed successfully").build();
    }
}
