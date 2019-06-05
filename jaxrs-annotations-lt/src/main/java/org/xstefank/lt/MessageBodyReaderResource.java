package org.xstefank.lt;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("message-body-reader")
public class MessageBodyReaderResource {

    @Context
    private UriInfo uriInfo;
    
    @GET
    @Path("test")
    public String get() {
        Client client = ClientBuilder.newClient();
        client.register(DummyMessageBodyReader.class);

        Response response = client.target(uriInfo.getBaseUriBuilder().path("message-body-reader").path("clientInvoke").build())
            .request().get();

        return response.readEntity(String.class);
    }
    
    @GET
    @Path("clientInvoke")
    @Produces("application/custom")
    public String clientInvoke() {
        return "Not expected message";
    }
}
