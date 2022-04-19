package io.xstefank;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

@Provider
public class MyFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) {
        // spec way
        Method method = (Method) requestContext
                .getProperty("org.eclipse.microprofile.rest.client.invokedMethod");

        Class<?> declaringClass = method.getDeclaringClass();
        System.out.println(declaringClass);

        MyAnnotation myAnnotation = declaringClass.getAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation.value());
    }
}
