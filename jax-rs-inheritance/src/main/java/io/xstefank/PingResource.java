package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ping")
public class PingResource extends PingSuperclass {

    @GET
    public String hello() throws NoSuchMethodException {
        System.out.println(JaxRsLikeAnnotationResolver.resolveAnnotation(TestAnnotation.class, PingResource.class.getMethod("hello")));

        return "hello";
    }
}
