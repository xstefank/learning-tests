package me.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello " + threadLocal.get();
    }

    @POST
    @Path("{value}")
    public String provide(@PathParam("value") String value) {
        threadLocal.set(value);
        return "Value set";
    }
}
