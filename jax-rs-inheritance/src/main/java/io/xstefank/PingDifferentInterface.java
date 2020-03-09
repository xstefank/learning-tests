package io.xstefank;

import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface PingDifferentInterface {

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @TestAnnotation("ping-different-interface")
    String hello() throws NoSuchMethodException;
}
