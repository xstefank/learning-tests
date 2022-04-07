package io.xstefank;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RegisterRestClient(baseUri = "http://example.com")
@MyAnnotation("myValue")
public interface MyRestClient {

    @GET
    String get();
}
