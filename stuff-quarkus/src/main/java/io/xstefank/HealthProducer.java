package io.xstefank;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class HealthProducer {
    
    @Produces
    @Liveness
    HealthCheck live() {
        return () -> HealthCheckResponse.named("live-check").up().build();
    }
    
    @Produces
    @Readiness
    HealthCheck ready() {
        return () -> HealthCheckResponse.named("ready-check").up().build();
    }
}
