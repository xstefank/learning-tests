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

        System.out.println(dayOfProgrammer(year));
        System.out.println(dayOfProgrammer(1918));
        scanner.close();
    }

    private static final int DAYS_NON_LEAP = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;

    public static String dayOfProgrammer(int year) {
        int day = 0;
        if (year == 1918) {
            // Feb 14th is the 32nd day of the year
            day = 256 - DAYS_NON_LEAP + 13;
        } else if (year < 1918) {
            day = year % 4 == 0 ? 256 - (DAYS_NON_LEAP + 1) : 256 - DAYS_NON_LEAP;
        } else {
            day = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ? 256 - (DAYS_NON_LEAP + 1) : 256 - DAYS_NON_LEAP;
        }

        return day + ".09." + year;
    }
}
