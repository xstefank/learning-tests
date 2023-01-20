package org.acme;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class MyClientRequestFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        System.out.println("MyClientRequestFilter.filter");

        System.out.println(requestContext.getConfiguration());
        System.out.println(requestContext.getPropertyNames());
    }
}
