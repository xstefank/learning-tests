package io.xstefank;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Liveness
public class TestHC implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return new HealthCheckResponse() {
            @Override
            public Status getStatus() {
                return super.getStatus();
            }
        };
    }
}
