package org.xstefank.lt;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("interceptor")
public class InterceptorResource {

    @Context
    private UriInfo uriInfo;
    
    @GET
    public String interceptor() {
        Client client = ClientBuilder.newClient();
//        client.register();

        Response response = client.target(uriInfo.getBaseUriBuilder().path("interceptor").path("interceptor-client").build())
            .request().post(Entity.text("test"));

        return response.readEntity(String.class);
    }

    @POST
    @Path("interceptor-client")
    public String interceptor(String s) {
        return s;
    }
}
