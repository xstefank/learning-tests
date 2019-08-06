package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://jsonplaceholder.typicode.com/posts");
        Response response = target.request().get();
        System.out.println(response.getStatus());

//        WebTarget target2 = client.target("http://www.google.com");
        Response response2 = target.request().post(null);
        System.out.println(response2.getStatus());

        client.close();
        return "hello";
    }
}
