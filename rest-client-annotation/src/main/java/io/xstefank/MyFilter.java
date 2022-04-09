package io.xstefank;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

@Provider
public class MyFilter implements ClientRequestFilter {
    @Override
    public void filter(ClientRequestContext requestContext) {
        System.out.println(requestContext);

        // spec way
        Method method = (Method) requestContext.getConfiguration()
            .getProperty("org.eclipse.microprofile.rest.client.invokedMethod");

        System.out.println(method.getDeclaringClass());

//        MyAnnotation myAnnotation = declaringClass.getAnnotation(MyAnnotation.class);
//        System.out.println(myAnnotation.value());
    }
}
