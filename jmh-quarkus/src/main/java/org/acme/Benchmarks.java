package org.acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import jakarta.enterprise.context.ApplicationScoped;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Benchmark)
@ApplicationScoped
public class Benchmarks {


    GreetingResource greetingResource;

    @Setup
    public void init() {
        ArcContainer container = Arc.initialize();
        greetingResource = container.instance(GreetingResource.class).get();
    }

    @Benchmark
    public void benchmark() {
        System.out.println(greetingResource.hello());
    }

    @TearDown
    public void tearDown() {
        Arc.shutdown();
    }
}
