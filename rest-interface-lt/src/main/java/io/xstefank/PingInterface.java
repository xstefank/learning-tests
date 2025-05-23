package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public interface PingInterface {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String hello(@HeaderParam("test") String value);
}
