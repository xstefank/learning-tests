package org.xstefank;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URL;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExampleClient client = RestClientBuilder.newBuilder()
                .baseUrl(new URL("http://example.com"))
                .build(ExampleClient.class);

        Response response = client.get();
        System.out.println("Status: " + response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
}
