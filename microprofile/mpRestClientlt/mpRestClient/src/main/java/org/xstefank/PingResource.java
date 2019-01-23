package org.xstefank;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URI;

@Path("ping")
@ApplicationScoped
public class PingResource {

    private PingRestClient pingRestClient = RestClientBuilder.newBuilder()
            .baseUrl(URI.create("http://localhost:8081").toURL()).build(PingRestClient.class);

    public PingResource() throws MalformedURLException {
    }

    @GET
    @Path("{param}")
    public Response ping(@PathParam("param") String param) {
        pingRestClient.getPing(param);
        return Response.ok("Application running successfully").build();
    }
}
