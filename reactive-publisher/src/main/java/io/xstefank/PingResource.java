package io.xstefank;

import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;
import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("/ping")
public class PingResource {

    @Inject
    @Stream("avengers")
    Emitter<String> avengers;
    
//    @Inject
//    @Stream("processed-avengers")
//    Publisher<String> processedAvengers;

    @POST
    @Path("/add")
    public String post(String post) {
        avengers.send(post);
        return post;
    }
    
//    @GET
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    public Publisher<String> stream() {
//        return processedAvengers;
//    }

    @Incoming("processed-avengers")
    @Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)
    public CompletionStage<Void> process(Message<Avenger> avenger) {
        return CompletableFuture.supplyAsync(avenger::getPayload)
            .thenApply(a -> a.name.toUpperCase()).thenAccept(System.out::println);
    }
}
