package io.xstefank;

import io.xstefank.util.HRService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Path("/")
public class HRResource {

    @Inject
    HRService hrService;

    @GET
    @Path("/bill-division")
    public void billDivision() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("bill-division.txt"));

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> bill = readList(scanner, n);
        int b = scanner.nextInt();

        scanner.close();

        bonAppetit(bill, k, b);
    }

    private void bonAppetit(List<Integer> bill, int k, int b) {
        int total = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                total += bill.get(i);
            }
        }

        if (total / 2 == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - total / 2);
        }
    }

    private List<Integer> readList(Scanner scanner, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        return list;
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
