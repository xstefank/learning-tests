package io.xstefank;

import org.jboss.resteasy.reactive.client.impl.ClientRequestContextImpl;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

@Provider
public class MyFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) {
        ClientRequestContextImpl clientRequestContext = (ClientRequestContextImpl) requestContext;
        Method method = (Method) clientRequestContext
            .getRestClientRequestContext()
            .getProperties()
            .get("org.eclipse.microprofile.rest.client.invokedMethod");
        Class<?> declaringClass = method.getDeclaringClass();

        MyAnnotation myAnnotation = declaringClass.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());
    }
}
