package io.xstefank;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvengerProcessor {

    @Incoming("avengers")
    @Outgoing("processed-avengers")
    @Broadcast
    public String process(String avenger) {
        return "Received avenger - " + avenger;
    }
}
