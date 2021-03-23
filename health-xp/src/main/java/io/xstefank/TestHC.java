package io.xstefank;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class TestHC implements HealthCheck {
    public HealthCheckResponse call() {
        return HealthCheckResponse.up("test");
    }
}
