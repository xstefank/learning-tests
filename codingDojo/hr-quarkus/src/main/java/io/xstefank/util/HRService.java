package io.xstefank.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@ApplicationScoped
public class HRService {

    @Inject
    ServletContext context;


    public Path getFile(String fileName) throws MalformedURLException, URISyntaxException {
        URL resource = context.getResource("/hr/input.txt");

        return Paths.get(resource.toURI());
    }

    public void outputDelimeter() {
        System.out.println("\n--------------------------------------\n");
    }
}
