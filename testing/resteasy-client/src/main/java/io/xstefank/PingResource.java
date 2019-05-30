package io.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {

    @Inject
    @ConfigProperty(name = "test")
    String test;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Client client = ClientBuilder.newClient();

        client.target("http://example.com")
            .request().get();
        
        return "hello";
    }
}
