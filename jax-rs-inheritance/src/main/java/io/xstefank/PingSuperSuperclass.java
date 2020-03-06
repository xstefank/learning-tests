package io.xstefank;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public abstract class PingSuperSuperclass {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public abstract String hello();
}
