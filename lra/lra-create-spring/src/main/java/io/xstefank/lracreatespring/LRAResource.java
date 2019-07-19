package io.xstefank.lracreatespring;

import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Component
@Path("/lra")
public class LRAResource {

    @GET
    @LRA(LRA.Type.REQUIRED)
    public Response doInLRA(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) String lraId, @Context HttpHeaders headers) {
        System.out.println(lraId);
        System.out.println(headers.getRequestHeader(LRA.LRA_HTTP_CONTEXT_HEADER));

        return Response.ok(lraId).build();
    }
}
