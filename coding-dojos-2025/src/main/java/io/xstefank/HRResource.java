package io.xstefank;

import io.xstefank.util.HRService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static io.xstefank.util.HRService.readList;

@Path("/")
public class HRResource {

    @Inject
    HRService hrService;

    @GET
    @Path("/countingValleys")
    public void countingValleys() throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("counting-valleys.txt"));

        int steps = scanner.nextInt();
        String path = scanner.next();

        scanner.close();

        System.out.println(countingValleys(steps, path));
    }

    public static int countingValleys(int steps, String path) {
        int position = 0;
        int valleys = 0;
        boolean inValley = false;

        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'D') {
                position--;
            } else if (path.charAt(i) == 'U') {
                position++;
            }

            if (!inValley) {
                if (position < 0) {
                    inValley = true;
                }
            } else {
                if (position == 0) {
                    valleys++;
                    inValley = false;
                }
            }
        }

        return valleys;
    }

    @GET
    @Path("/sales-by-match")
    public void salesByMatch () throws Exception {
        Scanner scanner = new Scanner(hrService.getFile("sales-by-match.txt"));

        int n = scanner.nextInt();
        List<Integer> ar = readList(scanner, n);

        scanner.close();

        System.out.println(sockMerchant(n, ar));
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        int pairsCount = 0;

        Set<Integer> pairs = new HashSet<>(n);

        for (int i = 0; i < n; i++) {
            Integer sock = ar.get(i);
            if (pairs.contains(sock)) {
                pairsCount++;
                pairs.remove(sock);
            } else {
                pairs.add(sock);
            }
        }

        return pairsCount;
    }

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
}
