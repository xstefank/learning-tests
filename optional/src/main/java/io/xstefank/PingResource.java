package io.xstefank;

import org.eclipse.microprofile.lra.annotation.ParticipantStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
//        Optional o = Optional.of("asdfasfd");
//        
//        Optional i = o;
//        try {
////            i.filter(ps -> ps instanceof ParticipantStatus).ifPresent(((ParticipantStatus) ps) -> System.out.println(ps.name()));
//        } catch (ClassCastException e) {
//            System.out.println("Error");
//        }
//        
//        return "hello";
    }
}
