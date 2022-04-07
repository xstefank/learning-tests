package io.xstefank;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {

    @RestClient
    MyRestClient myRestClient;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        myRestClient.get();
        return "Hello RESTEasy";
    }
}
