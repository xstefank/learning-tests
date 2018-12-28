package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;

@Path("ping")
public class PingResource {
    
    @GET
    @TestBinding
    public Response ping() throws MalformedURLException {
        ClientBuilder.newClient().target("http://example.com").request().get();
        return Response.ok("Application deployed successfully").build();
    }
}
