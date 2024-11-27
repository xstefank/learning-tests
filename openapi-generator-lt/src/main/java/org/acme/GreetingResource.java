package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.openapi.quarkus.openapi_yaml.api.ExtensionsApi;

@Path("/hello")
public class GreetingResource {

    @Inject
    @RestClient
    ExtensionsApi extensionsApi;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println(extensionsApi.extensions(null, null));
        return "Hello from Quarkus REST";
    }
}
