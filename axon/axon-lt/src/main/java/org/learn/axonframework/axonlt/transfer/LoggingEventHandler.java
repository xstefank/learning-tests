package org.learn.axonframework.axonlt.transfer;

import org.axonframework.eventhandling.EventHandler;

public class LoggingEventHandler {

    @EventHandler
    public void on(Object event) {
        System.out.println("Event received: " + event.toString());
    }

}
