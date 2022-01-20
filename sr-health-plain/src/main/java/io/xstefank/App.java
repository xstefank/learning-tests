package io.xstefank;

import io.smallrye.health.SmallRyeHealthReporter;
import io.smallrye.health.api.HealthRegistry;
import io.smallrye.health.api.HealthType;
import io.smallrye.health.registry.HealthRegistries;
import org.eclipse.microprofile.health.HealthCheckResponse;

import java.util.Collection;

public class App {
    public static void main(String[] args) {
        HealthRegistry livenessRegistry = HealthRegistries.getRegistry(HealthType.LIVENESS);
        HealthRegistry readinessRegistry = HealthRegistries.getRegistry(HealthType.READINESS);
        HealthRegistry startupRegistry = HealthRegistries.getRegistry(HealthType.STARTUP);
        HealthRegistry wellnessRegistry = HealthRegistries.getRegistry(HealthType.WELLNESS);

        HealthRegistry testGroupRegistry = HealthRegistries.getHealthGroupRegistry("test-group");
        Collection<HealthRegistry> healthGroupRegistries = HealthRegistries.getHealthGroupRegistries();

        livenessRegistry.register("test-hc", () -> HealthCheckResponse.up("test"));

        SmallRyeHealthReporter reporter = new SmallRyeHealthReporter();
        reporter.reportHealth(System.out, reporter.getHealth());
    }
}
