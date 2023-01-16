package io.xstefank;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.PUT;
import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.Complete;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("ping")
@ApplicationScoped
public class PingResource {
    
    @GET
    @LRA(value = LRA.Type.REQUIRED)
    public Response ping(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId) {
        System.out.println("ACTION lraId = " + lraId);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Response.ok("Application deployed successfully").build();
    }

//    @PUT
//    @Path("/compensate")
    @Compensate
    public Response compensate(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId) {
        System.out.println("COMPENSATE lraId = " + lraId);
        return Response.ok().build();
    }

//    @PUT
//    @Path("/complete")
    @Complete
    public void complete(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) URI lraId) {
        System.out.println("COMPLETE lraId = " + lraId.toASCIIString());
    }
}
