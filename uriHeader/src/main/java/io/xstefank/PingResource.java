package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@HeaderParam("header") URI header) throws URISyntaxException {
//        System.out.println(URI.create("server/%%%at"));
        
        return "hello " + header;
    }

    @GET
    @Path("test")
    public void test(@HeaderParam("header") int i) {
        System.out.println(i);
    } 
}
