package io.xstefank;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String hello() {
        Response response = ClientBuilder.newClient()
            .register(DummyMessageBodyTextPlain.class)
            .target("http://localhost:8081/ping")
            .request(MediaType.TEXT_PLAIN)
            .header("Content-Type", MediaType.TEXT_PLAIN)
            .header("Accept", MediaType.TEXT_PLAIN)
            .post(Entity.text("Dummy text"));
        return "hello " + response.readEntity(String.class);
    }
}
