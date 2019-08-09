package io.xstefank.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HRConfigSource implements ConfigSource {

    private Map<String, String> fileNames = new HashMap<>();

    public HRConfigSource() throws URISyntaxException, IOException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/resources/hr");

        Path hrPath = Paths.get(resource.toURI());

        DirectoryStream<Path> hrStream = Files.newDirectoryStream(hrPath);
        for (Path path : hrStream) {
            fileNames.put(path.getFileName().toString(), path.toAbsolutePath().toString());
        }
    }

    @Override
    public int getOrdinal() {
        return 500;
    }

    @Override
    public Map<String, String> getProperties() {
        return fileNames;
    }

    static AtomicInteger counter = new AtomicInteger(0);
    
    @Override
    public String getValue(String s) {
        if (!s.equals("input.txt")) {
            return null;
        }
        
        return "/home/mstefank/GIT/xstefank/learning-tests/codingDojo/hr-quarkus/target/classes/hr/input.txt";
    }

    @Override
    public String getName() {
        return "HRConfigSource";
    }
}
