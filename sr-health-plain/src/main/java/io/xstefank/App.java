package io.xstefank;

import io.smallrye.health.SmallRyeHealthReporter;
import io.smallrye.health.api.HealthRegistry;
import io.smallrye.health.api.HealthType;
import io.smallrye.health.registry.HealthRegistries;
import org.eclipse.microprofile.health.HealthCheckResponse;

public class App {
    public static void main(String[] args) {
        HealthRegistry livenessRegistry = HealthRegistries.getRegistry(HealthType.LIVENESS);

        livenessRegistry.register("test-hc", () -> HealthCheckResponse.up("test"));

        SmallRyeHealthReporter smallRyeHealthReporter = new SmallRyeHealthReporter();
        smallRyeHealthReporter.reportHealth(System.out, smallRyeHealthReporter.getHealth());
    }
}
