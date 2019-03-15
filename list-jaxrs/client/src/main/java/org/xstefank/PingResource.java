package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(URI.create("http://localhost:8081/ping"))
            .request().get();

        List<String> result = response.readEntity(new GenericType<List<String>>() {});
        
        return Response.ok("Application running successfully " + result).build();
    }
}
