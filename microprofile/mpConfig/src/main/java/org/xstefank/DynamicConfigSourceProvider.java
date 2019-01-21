package org.xstefank;

import org.eclipse.microprofile.config.spi.ConfigSource;
import org.eclipse.microprofile.config.spi.ConfigSourceProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicConfigSourceProvider implements ConfigSourceProvider {
    @Override
    public Iterable<ConfigSource> getConfigSources(ClassLoader forClassLoader) {
        List<ConfigSource> configSources = new ArrayList<>();

        Map<String, String> memoryMap = new HashMap<>();
        memoryMap.put("test-prop", "test new memory prop");

        configSources.add(new MemoryConfigSource(memoryMap));
        
        return configSources;
    }
}
