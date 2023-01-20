package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@ApplicationScoped
public class MyClientRequestFilter implements ClientRequestFilter {

    @Inject
    TestRequestScoped testRequestScoped;

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        System.out.println("MyClientRequestFilter.filter");
        System.out.println(testRequestScoped.getHello());

        System.out.println(requestContext.getConfiguration());
        System.out.println(requestContext.getPropertyNames());
    }
}
