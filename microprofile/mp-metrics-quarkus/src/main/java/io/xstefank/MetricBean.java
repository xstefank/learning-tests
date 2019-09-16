package io.xstefank;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MetricBean {

    private static final String COUNTER_NAME = "test-counter";
    
    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry applicationMetricRegistry;

    public void registerMetric() {
        Counter counter = applicationMetricRegistry.counter(COUNTER_NAME);
        counter.inc();
    }
    
    public void unregisterMetric() {
        applicationMetricRegistry.remove(COUNTER_NAME);
    }
}
