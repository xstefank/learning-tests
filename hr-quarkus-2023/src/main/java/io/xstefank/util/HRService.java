package io.xstefank.util;

import javax.enterprise.context.ApplicationScoped;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@ApplicationScoped
public class HRService {


    public Path getFile(String fileName) {
        URL resource = this.getClass().getClassLoader().getResource("META-INF/resources/hr/" + fileName);

        try {
            return Paths.get(resource.toURI());
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public void outputDelimeter() {
        System.out.println("\n--------------------------------------\n");
    }
}
