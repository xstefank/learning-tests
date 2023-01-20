package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class GreetingResource {

    @Context
    UriInfo uriInfo;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Client client = ClientBuilder.newClient();

        client.target(uriInfo.getBaseUri())
            .path("something")
            .request()
            .get();

        client.close();

        return "Hello from RESTEasy Reactive";
    }


    @GET
    @Path("/something")
    public void something() {
        System.out.println("GreetingResource.something");
    }


}