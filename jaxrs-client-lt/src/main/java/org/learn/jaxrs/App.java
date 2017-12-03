package org.learn.jaxrs;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class App {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/test");

        Response response = target.request().get();
        String value = response.readEntity(String.class);
        response.close();
    }
}
