package io.xstefank;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String hello() {
        Invocation.Builder request = ClientBuilder.newClient()
            .target("http://localhost:8081/ping")
            .register(DummyMessageBodyTextPlain.class)
            .request("application/useless");
        Response response = request
            .get();
        return "hello " + response.readEntity(String.class);
    }
}
