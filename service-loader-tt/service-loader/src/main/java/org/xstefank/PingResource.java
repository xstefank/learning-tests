package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.ServiceLoader;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() {
        ServiceLoader<Dummy> serviceLoader = ServiceLoader.load(Dummy.class, ClassLoader.getSystemClassLoader());
        System.out.println("service loader");
        serviceLoader.iterator().forEachRemaining(x -> System.out.println("class: " + x.getClass().getName() + ", " + x.hello()));


        return Response.ok("Application running successfully").build();
    }
}
