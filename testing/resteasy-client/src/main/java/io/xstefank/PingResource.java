package io.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ping")
public class PingResource {
    
    @Inject
    @ConfigProperty(name = "ints")
    private List<Integer> ints;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println(ints);
//        GitHubAPI.update();
        
        return "hello";
    }
}
