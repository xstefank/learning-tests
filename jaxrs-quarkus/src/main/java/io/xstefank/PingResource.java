package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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

    @GET
    @Path("interceptor")
    public String interceptor() {
        Client client = ClientBuilder.newClient();
        client.register(DummyReaderInterceptor.class);

        Response response = client.target(uriInfo.getBaseUriBuilder().path("interceptor-client").build())
            .request().post(Entity.text("test"));

        return response.readEntity(String.class);
    }
    
    @POST
    @Path("interceptor-client")
    public String interceptor(String s) {
        System.out.println("Received " + s);
        return s;
    }
    
    @GET
    @Path("no-annotation")
    public String noAnnoation() {
        Client client = ClientBuilder.newClient();

        Response response = client.target(uriInfo.getBaseUriBuilder().path("no-annotation-client").build())
            .request().get();

        return response.readEntity(String.class);
    }
    
    @GET
    @Path("abortWith456")
    public Response abortWith456() {
        Client client = ClientBuilder.newClient();
        client.register(DummyDynamicFeature.class);

        Response response = client.target(uriInfo.getBaseUriBuilder().path("abortWith456-client").build())
            .request().get();

        return Response.status(response.getStatus()).entity(response.hasEntity() ? response.readEntity(String.class) : null).build();
    }
    
    @GET
    @Path("no-annotation-client")
    public String noAnnotationClient() {
        return "everything ok";
    }
    
    @GET
    @Path("abortWith456-client")
    @AbortWith456
    public String abortWith456Client() {
        return "everything ok";
    }
}
