package io.xstefank;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("test")
public class TestClass {
    
    @GET
    @LRA
    public Response lra() {
        return Response.ok().build();
    }

    @POST
    public String another() {
        return "hello";
    }
    
    @Compensate
    public Response compensate() {
        return Response.ok().build();
    }
}
