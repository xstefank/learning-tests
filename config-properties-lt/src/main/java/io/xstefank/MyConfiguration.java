package io.xstefank;

import io.quarkus.arc.config.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Optional;

@ConfigProperties(prefix = "my")
public interface MyConfiguration {

    @ConfigProperty(name = "value.test")
    public Optional<String> value();
}
