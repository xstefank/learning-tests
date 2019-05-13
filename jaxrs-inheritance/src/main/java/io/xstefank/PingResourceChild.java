package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/child")
public class PingResourceChild {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2() {
        return "hello2";
    }
}
