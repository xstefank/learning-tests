package io.xstefank;

import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/lra")
public class LRAResource {

    @Context
    private UriInfo uriInfo;
    
    @GET
    @LRA(LRA.Type.REQUIRED)
    public String doInLRA(@HeaderParam(LRA.LRA_HTTP_CONTEXT_HEADER) URI lraId) {
        System.out.println("LRA: " + lraId.toASCIIString());

        Client client = ClientBuilder.newClient();
        Response response = client.target(uriInfo.getBaseUriBuilder().path("lra/pojo/lra").build())
            .request().get();
        System.out.println(response.getStatus());
        
        return lraId.toASCIIString();
    }
    
    @Path("/pojo")
    public POJOParticipant pojo() {
        return new POJOParticipant();
    }
}
