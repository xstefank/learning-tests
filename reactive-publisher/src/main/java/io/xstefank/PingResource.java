package io.xstefank;

import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/ping")
public class PingResource {

    @Inject
    @Stream("avengers")
    Emitter<String> avengers;
    
    
//    @GET
//    @Produces(MediaType.SERVER_SENT_EVENTS)
    @Incoming("avengers")
    public void publisher(String avenger) {
        System.out.println("Received avenger - " + avenger);
    }

    @GET
    @Path("/{post}")
    public String post(@PathParam("post") String post) {
        avengers.send(post);
        return post;
    }
}
