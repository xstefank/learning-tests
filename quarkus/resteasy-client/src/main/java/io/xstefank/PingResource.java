package io.xstefank;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResource {

    private Logger log = Logger.getLogger(PingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Response response = ClientBuilder.newClient()
            .target("http://example.com")
            .request().get();

        log.info("status: " + response.getStatus());
        log.info("body: " + response.readEntity(String.class));
        
        return "hello";
    }
}
