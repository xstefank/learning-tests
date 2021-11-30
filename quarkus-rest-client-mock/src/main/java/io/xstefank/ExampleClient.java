package io.xstefank;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@ApplicationScoped
@RegisterRestClient(baseUri = "http://example.com")
public interface ExampleClient {

    @GET
    String get();
}
