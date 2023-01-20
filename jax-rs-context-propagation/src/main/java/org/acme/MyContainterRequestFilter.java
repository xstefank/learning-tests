package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@ApplicationScoped
public class MyContainterRequestFilter implements ContainerRequestFilter {

    @Inject
    TestRequestScoped testRequestScoped;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("MyContainterRequestFilter.filter");
        System.out.println(testRequestScoped.getHello());

        requestContext.setProperty("my-prop", "test-filter-value");
    }
}
