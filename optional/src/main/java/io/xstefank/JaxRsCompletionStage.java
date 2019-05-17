package io.xstefank;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.ParticipantStatus;
import org.eclipse.microprofile.lra.annotation.Status;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("jax-rs-participant")
public class JaxRsCompletionStage {

    @GET
    @Path("enlist")
    @LRA(LRA.Type.REQUIRES_NEW)
    public Response enlist(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId) {
        return Response.ok().build();
    }
    
    @PUT
    @Path("compensate")
    @Compensate
    public CompletionStage<Optional<ParticipantStatus>> complete(URI lraId) {
        return CompletableFuture.supplyAsync(() -> {
            startDoingSomeBusinessWork(lraId);
            
            return Optional.of(ParticipantStatus.Compensating);
        });
    }
    
    @GET
    @Path("status")
    @Status
    public Optional<ParticipantStatus> status(URI lraId) {
        if (checkBusinessWorkIsDone(lraId)) {
            return Optional.of(ParticipantStatus.Compensated);
        } else {
            return Optional.of(ParticipantStatus.Compensating);
        }
    }

    private void startDoingSomeBusinessWork(URI lraId) {
        // intentionally empty
    }

    private boolean checkBusinessWorkIsDone(URI lraId) {
        return false;
    }
}
 
