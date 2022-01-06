package io.xstefank;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class ServerFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Inject
    MyRequestScopedBean myRequestScopedBean;

    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("Container request " + myRequestScopedBean.getUuid());
    }

    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("Container response " + myRequestScopedBean.getUuid());
    }
}
