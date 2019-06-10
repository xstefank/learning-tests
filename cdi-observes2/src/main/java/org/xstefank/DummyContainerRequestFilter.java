package org.xstefank;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class DummyContainerRequestFilter implements ContainerRequestFilter {
    
    @Inject
    TestRegistry testRegistry;
    
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("XXXXXXXXXXXXXXXXx " + testRegistry.getValue());
    }
}
