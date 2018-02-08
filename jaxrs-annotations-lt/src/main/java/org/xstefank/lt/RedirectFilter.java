package org.xstefank.lt;

import org.jboss.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.net.URI;

@Provider
@PreMatching
public class RedirectFilter implements ContainerRequestFilter {


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getPath().startsWith("/redirect")) {
            Logger.getLogger(RedirectFilter.class).info("redirecting to /dummy");
            requestContext.setRequestUri(URI.create("/redirect/dummy"));
        }
    }
}
