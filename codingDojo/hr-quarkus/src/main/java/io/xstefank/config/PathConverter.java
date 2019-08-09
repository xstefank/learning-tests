package io.xstefank.config;

import org.eclipse.microprofile.config.spi.Converter;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathConverter implements Converter<Path> {
    
    @Override
    public Path convert(String s) {
        return Paths.get(URI.create(s));
    }
}
