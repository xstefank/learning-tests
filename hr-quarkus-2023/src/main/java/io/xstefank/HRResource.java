package io.xstefank;

import io.xstefank.util.HRService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;

@Path("/hr")
public class HRResource {

    @Inject
    HRService hrService;

    @GET
    @Path("/advent2022_0101")
    public void advent2022_0101() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("advent2022_0101.txt"));

        Long maxCalories = 0L;
        Long currentCalories = 0L;

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (!s.isEmpty()) {
                currentCalories += Long.parseLong(s);
            } else {
                if (currentCalories > maxCalories) {
                    maxCalories = currentCalories;
                }
                currentCalories = 0L;
            }
        }

        System.out.println(maxCalories);

    }

    @GET
    @Path("/advent2022_0102")
    public void advent2022_0102() throws IOException {
        // same output as 0101
        Scanner scanner = new Scanner(hrService.getFile("advent2022_0101.txt"));

        PriorityBlockingQueue<Long> maxCalories = new PriorityBlockingQueue<Long>();
        Long currentCalories = 0L;

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (!s.isEmpty()) {
                currentCalories += Long.parseLong(s);
            } else {
                maxCalories.put(currentCalories);
                if (maxCalories.size() > 3) {
                    maxCalories.poll();
                }
                currentCalories = 0L;
            }
        }

        System.out.println(maxCalories.poll() + maxCalories.poll() + maxCalories.poll());

    }



}
