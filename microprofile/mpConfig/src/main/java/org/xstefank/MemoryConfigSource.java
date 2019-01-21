package org.xstefank;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Map;

public class MemoryConfigSource implements ConfigSource {
    private Map<String, String> properties;

    public MemoryConfigSource(Map<String, String> properties) {
        this.properties = properties;
    }

    @Override
    public int getOrdinal() {
        return 900;
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "Custom Memory Config source";
    }
}
