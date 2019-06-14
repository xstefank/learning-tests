package io.xstefank;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.ParticipantStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("ping")
public class PingResource {
    
    @GET
    public Response ping() {
        return Response.ok("Application running successfully").build();
    }
    
    @Compensate
    public void cancelBooking(URI lraId) {
        if (//something) {
            throw new RuntimeException(); // results in FailedToCompensate
        } else if (// something else) {
            throw new WebApplicationException(Response.accepted().build()); // indicate Compensating
        }
        // else cancel the booking with id lraId
    }
}
