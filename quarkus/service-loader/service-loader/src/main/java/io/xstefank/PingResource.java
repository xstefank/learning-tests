package io.xstefank;

import org.xstefank.Dummy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ServiceLoader;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        ServiceLoader<Dummy> serviceLoader = ServiceLoader.load(Dummy.class);
        System.out.println("service loader");
        serviceLoader.iterator().forEachRemaining(x -> System.out.println("class: " + x.getClass().getName() + ", " + x.hello()));
        
        return "hello";
    }
}
