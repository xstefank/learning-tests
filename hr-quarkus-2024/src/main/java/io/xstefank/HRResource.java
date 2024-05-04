package io.xstefank;

import io.xstefank.util.HRService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.io.IOException;
import java.util.Scanner;

@Path("/hr")
public class HRResource {

    @Inject
    HRService hrService;

    @GET
    @Path("/day-of-the-programmer")
    public void dayOfTheProgrammer() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("day-of-the-programmer.txt"));

        int year = scanner.nextInt();


        System.out.println(maxCalories);
        scanner.close();
    }
}
