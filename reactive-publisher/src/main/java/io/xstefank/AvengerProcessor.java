package io.xstefank;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AvengerProcessor {

    @Incoming("avengers")
    @Outgoing("processed-avengers")
    @Broadcast
    public Message<Avenger> process(String avenger) {
        Avenger avenger1 = new Avenger();
        avenger1.name = avenger;
        avenger1.civilName = "Fake";
        return Message.of(avenger1);
    }
}
