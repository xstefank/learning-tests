package io.xstefank;

import org.jboss.resteasy.client.jaxrs.internal.ClientRequestContextImpl;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class MyFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) {
        Class<?> declaringClass = ((ClientRequestContextImpl) requestContext)
            .getInvocation()
            .getClientInvoker()
            .getDeclaring();

        MyAnnotation myAnnotation = declaringClass.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());
    }
}
