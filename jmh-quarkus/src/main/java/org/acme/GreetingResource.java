package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;

@Path("/")
public class GreetingResource {

    @Benchmark
    public void init() {

    }

    @GET
    @Path("/jmh")
    public void jmh() throws IOException {
        System.out.println(getClass().getClassLoader());
        org.openjdk.jmh.Main.main(new String[]{});
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }


}
