package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/ping")
public class PingResource {

    @Context
    private UriInfo uriInfo;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(uriInfo.getBaseUriBuilder().path("ping/client").build())
            .request().get();

        URI uri = response.readEntity(URI.class);
        System.out.println(uri);
        return "hello";
    }
    
    @GET
    @Path("client")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getURI() {
        return Response.ok(URI.create("http://example.com")).build();
    }
}
