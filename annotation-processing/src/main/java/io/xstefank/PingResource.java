package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {


        System.out.println(getAnnotation(TestAnnotation.class, SubClass.class.getMethod("myMethod")));

        return "hello";
    }

    private <T extends Annotation> T getAnnotation(Class<T> annotationClass, Method method) {
        T annotation = method.getAnnotation(annotationClass);
        if (annotation != null) {
            return annotation;
        } else {
            // get the annotation from methods defined in the super-classes
            Class<?> current = method.getDeclaringClass().getSuperclass();
            while (current != null) {
                Method superClassMethod
            }

            // get the annotation from the methods defined in the implemented interfaces
        }
    }
}
