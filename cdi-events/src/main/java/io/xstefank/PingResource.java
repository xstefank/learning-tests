package io.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
@ApplicationScoped
public class PingResource {

    @Inject
    Event<MyEvent> event;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        event.fire(new MyEvent());
        return "hello";
    }
}
