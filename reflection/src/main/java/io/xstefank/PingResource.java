package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws Exception {
        Method method = Dummy.class.getDeclaredMethod("foo");
        Type returnType = method.getGenericReturnType();
        ParameterizedType ptype  = (ParameterizedType) returnType;
        Type type = ptype.getActualTypeArguments()[0];
        System.out.printf("Participant#compensate return type name %s%n", returnType.getTypeName());
        System.out.printf("Participant#compensate returns %s%n", type.getTypeName());
        
        
        return "hello";
    }
}
