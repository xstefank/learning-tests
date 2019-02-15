package org.xstefank;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("")
@RegisterRestClient
public interface ExampleClient {
    
    @GET
    @Path("")
    Response get();
}
