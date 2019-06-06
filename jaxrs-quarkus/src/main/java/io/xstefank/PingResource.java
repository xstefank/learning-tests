package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/")
public class PingResource {

    @Context
    private UriInfo uriInfo;
    
    @GET
    @Path("test")
    public String hello() {
        Client client = ClientBuilder.newClient();
        client.register(DummyMBR.class);

        Response response = client.target(uriInfo.getBaseUriBuilder().path("client").build())
            .request().get();

        return response.readEntity(String.class);
    }
    
    @GET
    @Path("client")
    @Produces("application/custom")
    public String client() {
        return "custom different";
    }
    
    @GET
    @Path("async")
    public String async() {
        Client client = ClientBuilder.newClient();
        client.register(DummyAsyncClientResponseProvider.class);

        Response response = client.target(uriInfo.getBaseUriBuilder().path("async-client").build())
            .request().get();

        return response.readEntity(String.class);
    }
    
    @GET
    @Path("async-client")
    public CompletionStage<String> asyncClient() {
        return CompletableFuture.supplyAsync(() -> "original string");
    }
}
