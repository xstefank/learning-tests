package io.xstefank;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ping")
@ApplicationScoped
public class PingResource {

    @Inject
    SantaClausService service;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        service.createGift("test");
        return "hello change";
    }
}
