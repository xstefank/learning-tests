package org.xstefank;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("ping")
@ApplicationScoped
public class PingResource {
    
    @Inject
    @Metric(name = "metric counter", absolute = true)
    private Counter metricCounter;
    
    
    @GET
    @Counted(name = "ping requests", monotonic = true, absolute = true)
    public Response ping() {
        return Response.ok("Application running successfully").build();
    }

    @GET
    @Path("ping2")
    @Counted(name = "ping2 requests", absolute = true)
    public Response ping2() {
        return Response.ok("Application running successfully").build();
    }

    @GET
    @Path("ping3")
    @Gauge(name = "ping3 gauge", unit = MetricUnits.NONE,  
            absolute = true, description = "test gauge", tags = {"key1=val1", "key2=val2"})
    public double ping3() {
        return Math.random();
    }

    @GET
    @Path("ping4")
    @Timed(name = "ping4 timer", absolute = true)
    public Response ping4() {
        return Response.ok("Application running successfully").build();
    }

    @GET
    @Path("ping5")
    @Metered(name = "ping5 meter", absolute = true)
    public Response ping5() {
        return Response.ok("Application running successfully").build();
    }

    @GET
    @Path("ping6")
    public Response ping6() {
        metricCounter.inc();
        return Response.ok("Application running successfully - " + metricCounter.getCount()).build();
    }
}
