package io.xstefank;

import io.xstefank.util.HRService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

@Path("/hr")
public class HRResource {
    
    @Inject
    HRService hrService;

 
    @GET
    @Path("/input")
    public void input() throws IOException, URISyntaxException {

        Scanner scanner = new Scanner(hrService.getFile("/hr/input.txt"));

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        hrService.outputDelimeter();
    }
}
