package org.eclipsecon;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IotConsumer {
    
    @Incoming("external-kafka")
    public void consume(String message) {
        System.out.println("message = " + message);
    }
    
}
