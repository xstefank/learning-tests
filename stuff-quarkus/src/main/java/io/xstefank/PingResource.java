package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/")
public class PingResource {

    @GET
    @Path("files")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
//        java.nio.file.Path path = java.nio.file.Path.of("test.txt");
//        System.out.println(path.toAbsolutePath().toString());
//
//        try {
//            Files.write(path, "test".getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return "hello";
    }

    private AtomicInteger counter = new AtomicInteger(0);
    
    @GET
    @Path("accept")
    public Response accept() {
        return Response.status(Response.Status.CREATED)
            .header("test", "value" + counter.incrementAndGet()).build();
    }
}
