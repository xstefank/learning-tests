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

        Scanner scanner = new Scanner(hrService.getFile("input.txt"));

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        scanner.close();
        hrService.outputDelimeter();
    }
    
    @GET
    @Path("/ifElse")
    public void ifElse() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("ifElse.txt"));

        int n = scanner.nextInt();

        if (n % 2 == 1) {
            System.out.println("Weird");
        } else if (n >= 2 && n <= 5) {
            System.out.println("Not Weird");
        } else if (n >= 6 && n <= 20) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
        
        scanner.close();
        hrService.outputDelimeter();
    }
    
    @GET
    @Path("stdII")
    public void stdII() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("stdII.txt"));

        int i = scanner.nextInt();
        double d = scanner.nextDouble();
        scanner.nextLine();
        String s = scanner.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        
        scanner.close();
        hrService.outputDelimeter();
    }
    
    
    
}
