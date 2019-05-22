package io.xstefank;

import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
public class PingResource {

    @Inject
    @Stream("avengers")
    Emitter<String> avengers;
    
    @Inject
    @Stream("processed-avengers")
    Publisher<String> processedAvengers;

    @POST
    @Path("/add")
    public String post(String post) {
        avengers.send(post);
        return post;
    }
    
    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> stream() {
        return processedAvengers;
    }
}
