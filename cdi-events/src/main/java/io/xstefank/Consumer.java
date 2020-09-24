package io.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class Consumer {

    void onMyEvent(@Observes MyEvent event) {
        System.out.println(event);
    }
}
