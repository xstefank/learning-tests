package org.xstefank;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class App {

    public static void main(String[] args) {
        Response response = ClientBuilder.newClient().target("http://example.com")
                .request().get();

        System.out.println("Status " + response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}
