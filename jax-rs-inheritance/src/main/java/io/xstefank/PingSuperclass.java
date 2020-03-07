package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public abstract class PingSuperclass implements PingDifferentInterface {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public abstract String hello();
}
