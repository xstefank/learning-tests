package io.xstefank;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
//        ExampleClient client = RestClientBuilder.newBuilder()
//            .baseUri(URI.create("http://example.com"))
//            .build(ExampleClient.class);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://example.com");
        ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget) target;

        ExampleClient exampleClient = resteasyWebTarget.proxy(ExampleClient.class);

        String s = exampleClient.example();
        System.out.println(s);
        return "hello";
    }
}
