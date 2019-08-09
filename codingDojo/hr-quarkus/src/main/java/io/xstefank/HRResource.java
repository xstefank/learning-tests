package io.xstefank;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Scanner;

@Path("/hr")
public class HRResource {
    
//    @ConfigProperty(name = "input.txt")
//    java.nio.file.Path inputPath;
    
    @GET
    @Path("/input")
    public void input() throws IOException, URISyntaxException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/resources/hr/input.txt");
        Scanner scanner = new Scanner(Paths.get(resource.toURI()));
//
        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//
        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
    }
}
