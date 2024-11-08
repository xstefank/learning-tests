package io.xstefank;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.Complete;
import org.eclipse.microprofile.lra.annotation.Forget;
import org.eclipse.microprofile.lra.annotation.ParticipantStatus;
import org.eclipse.microprofile.lra.annotation.Status;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/lra")
@ApplicationScoped
public class LRAParticipant {

    @GET
    @Path("/doInLRA")
    @LRA(LRA.Type.REQUIRED)
    public Response doInLRA(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId) {
        System.out.println("enlisting and ending LRA " + lraId);
        return Response.ok().build();
    } 
    
    @Complete
    public Response complete(URI lraId) {
        System.out.println("Completing " + lraId);
        return Response.ok(ParticipantStatus.Completed).build();
    }

    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_PLAIN)
    @Status
    public Response status(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId) {
        System.out.println("Status for " + lraId);
        return Response.ok(ParticipantStatus.Completed.name()).build();
    }

    @DELETE
    @Path("/forget")
    @Produces(MediaType.TEXT_PLAIN)
    @Forget
    public Response forget(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId) {
        System.out.println("Forget for " + lraId);
        return Response.ok(ParticipantStatus.Completed.name()).build();
    }
    
    @PUT
    @Path("/compensate")
    @Compensate
    public Response compensate(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId) {
        System.out.println("Compensating " + lraId);
        return Response.ok().build();
    }
}
