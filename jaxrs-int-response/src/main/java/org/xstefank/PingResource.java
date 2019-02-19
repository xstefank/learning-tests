package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.concurrent.atomic.AtomicInteger;

@Path("ping")
public class PingResource {

    @Context
    private UriInfo uriInfo;
    
    @GET
    public Response ping() {
        Response response = ClientBuilder.newClient().target(uriInfo.getBaseUriBuilder().path("ping/client").build())
                .request().get();

        int i = response.readEntity(Integer.class);

        return Response.ok("Application deployed successfully " + i).build();
    }
    
    @GET
    @Path("client")
    public Response getClient() {
        return Response.ok(new AtomicInteger(0).intValue()).build();
    }
}
