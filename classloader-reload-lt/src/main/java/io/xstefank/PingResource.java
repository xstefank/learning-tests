package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        InputStream resourceAsStream = cl.getResourceAsStream("java/util/Collections.class");
        int read = resourceAsStream.read();

        System.out.println(read);

        resourceAsStream = cl.getResourceAsStream("java/util/Collections.class");
        read = resourceAsStream.read();

        System.out.println(read);

        return "hello";
    }
}
