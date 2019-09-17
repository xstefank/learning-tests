package io.xstefank;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient(baseUri = "http://example.com")
@RegisterProvider(MyResponseExceptionMapper.class)
public interface ExampleClient {
    
    @GET
    @Path("/fake")
    String get();
}
