package me.xstefank;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/ping")
public class PingResource {

    @Inject
    private Current current;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello " + current.get();
    }

    @POST
    @Path("{value}")
    public String provide(@PathParam("value") String value) {
        current.set(value);
        return "Value set";
    }
}
