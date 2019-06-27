package io.xstefank;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@Liveness
@ApplicationScoped
public class TestHC implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        Random random = new Random();
        return HealthCheckResponse.named("testHC").state(random.nextBoolean()).build();
    }
}
