package io.xstefank;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.temporal.ChronoUnit;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @Timeout(4000)
    public void timeoutDefault() {
        // ...
    }
    
    @Timeout(value = 4, unit = ChronoUnit.SECONDS)
    public void timeout() {
        // ...
    }
    
    @GET
    @Path("fallback")
    @Fallback(MyFallbackHandler.class)
    public String fallbackedMethod() {
        throw new RuntimeException();
    }
    
    @GET
    @Path("fallback-method")
    @Fallback(fallbackMethod = "fallbackMethod")
    public String fallbackedMethod2() {
        throw new RuntimeException();
    }
    
    public String fallbackMethod() {
        return "fallback method value";
    }
}
