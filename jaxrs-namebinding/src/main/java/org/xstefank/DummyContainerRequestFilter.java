package org.xstefank;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@TestBinding
public class DummyContainerRequestFilter implements ContainerRequestFilter {


    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX ContainerRequestFilter");
    }
}
