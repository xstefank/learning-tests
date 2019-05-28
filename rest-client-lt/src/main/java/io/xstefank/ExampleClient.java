package io.xstefank;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;

//@RegisterRestClient
public interface ExampleClient {
    
    @GET
    String example();
}
