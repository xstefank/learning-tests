package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface PingInterface {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String hello();
}
