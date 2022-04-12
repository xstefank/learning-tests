package io.xstefank;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ServerFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.getHeaders().putSingle("Base-URI", requestContext.getUriInfo().getBaseUri().toASCIIString());
    }
}
