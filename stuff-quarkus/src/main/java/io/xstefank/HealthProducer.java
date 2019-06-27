package io.xstefank;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class HealthProducer {
    
    @Produces
    @Liveness
    HealthCheck live1() {
        return () -> HealthCheckResponse.named("asdf").state(true).build();
    }
}
