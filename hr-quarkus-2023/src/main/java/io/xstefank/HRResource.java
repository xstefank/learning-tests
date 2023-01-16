package io.xstefank;

import io.xstefank.util.HRService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.Scanner;

@Path("/hr")
public class HRResource {

    @Inject
    HRService hrService;

    @GET
    @Path("/advent2022_0101")
    public void advent2022_0101() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("advent2022_0101.txt"));

        System.out.println(scanner.nextLine());

    }

}
