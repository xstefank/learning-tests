package org.xstefank;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CustomClientRequestFilter implements ClientRequestFilter {
    public void filter(ClientRequestContext requestContext) throws IOException {
        requestContext.abortWith(Response.status(404).build());
    }
}
