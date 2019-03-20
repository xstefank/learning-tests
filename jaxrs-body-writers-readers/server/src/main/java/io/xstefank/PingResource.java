package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/ping")
public class PingResource {

    @GET
    @Produces("application/useless")
    public String hello(String text) {
        return "hello " + text;
    }
}
