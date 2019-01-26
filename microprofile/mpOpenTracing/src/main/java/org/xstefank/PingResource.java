package org.xstefank;

import io.opentracing.Tracer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
public class PingResource {
    
    @Inject
    private Tracer tracer;
    
    @GET
    public Response ping() {
        tracer.activeSpan().setTag("custom", "tag");
        tracer.activeSpan().setBaggageItem("host", System.getProperty("os.name"));
        
        return Response.ok("Application running successfully").build();
    }
}
