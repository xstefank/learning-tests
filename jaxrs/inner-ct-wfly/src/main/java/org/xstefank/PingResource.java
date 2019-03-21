package org.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/ping")
public class PingResource {

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces("application/custom")
    public String hello() {
        Response response = ClientBuilder.newClient().target(uriInfo.getBaseUriBuilder().path("inner"))
            .request().get();

        System.out.println(response.getHeaders());
        System.out.println(response.getHeaderString("Content-Type"));

        return "hello";
    }

    @GET
    @Path("inner")
    @Produces("application/custom")
    public String whatever() {
        return "whatever";
    }
}
