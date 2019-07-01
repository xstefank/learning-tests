package io.xstefank;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.Complete;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.net.URI;

public class POJOParticipant {

    @GET
    @Path("/lra")
    @LRA(LRA.Type.REQUIRED)
    public void doInLRA(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) URI lraId) {
        System.out.println("POJO LRA: " + lraId);
    }

    @PUT
    @Path("/compensate")
    @Compensate
    public void compensate(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) URI lraId) {
        System.out.println("Compensate: " + lraId);
    }

    @PUT
    @Path("/complete")
    @Complete
    public void complete(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) URI lraId) {
        System.out.println("Complete: " + lraId.toASCIIString());
    }
}
