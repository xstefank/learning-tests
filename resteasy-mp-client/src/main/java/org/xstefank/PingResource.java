package org.xstefank;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() throws MalformedURLException {
        ExampleClient client = RestClientBuilder.newBuilder()
                .baseUrl(new URL("http://example.com"))
                .build(ExampleClient.class);

        Response response = client.get();
        System.out.println("Status: " + response.getStatus());
        System.out.println(response.readEntity(String.class));

        return Response.ok("Application deployed successfully").build();
    }
}
