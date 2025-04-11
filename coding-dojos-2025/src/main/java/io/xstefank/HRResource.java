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
import static io.xstefank.util.HRService.readMatrix;

@Path("/")
public class HRResource {

    @Inject
    HRService hrService;

    @GET
    @Path("/formingMagicSquare")
    public void formingMagicSquare() throws IOException {
        Scanner scanner = new Scanner(hrService.getFile("forming-magic-square.txt"));

        List<List<Integer>> s = readMatrix(scanner, 3);

        System.out.println(formingMagicSquare(s));
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        int magicSquares[][] = {
            {2, 9, 4, 7, 5, 3, 6, 1, 8},
            {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {4, 3, 8, 9, 5, 1, 2, 7, 6},
            {8, 3, 4, 1, 5, 9, 6, 7, 2},
            {6, 7, 2, 1, 5, 9, 8, 3, 4},
            {2, 7, 6, 9, 5, 1, 4, 3, 8},
            {6, 1, 8, 7, 5, 3, 2, 9, 4},
            {8, 1, 6, 3, 5, 7, 4, 9, 2}
        };

        int minCost = 30;
        for (int k = 0; k < 8; k++) {
            int cost = 0;
            cost += Math.abs(magicSquares[k][0] - s.get(0).get(0))+Math.abs(magicSquares[k][1] - s.get(0).get(1))+Math.abs(magicSquares[k][2] - s.get(0).get(2));
            cost += Math.abs(magicSquares[k][3] - s.get(1).get(0))+Math.abs(magicSquares[k][4] - s.get(1).get(1))+Math.abs(magicSquares[k][5] - s.get(1).get(2));
            cost += Math.abs(magicSquares[k][6] - s.get(2).get(0))+Math.abs(magicSquares[k][7] - s.get(2).get(1))+Math.abs(magicSquares[k][8] - s.get(2).get(2));

            if (cost < minCost) {
                minCost = cost;
            }
        }


        return minCost;
    }

    private static boolean isValidMagicSquare(List<List<Integer>> s) {
        int magicNumber = s.get(0).stream().mapToInt(Integer::intValue).sum();
        int sum;

        // check rows
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += s.get(i).get(j);
            }
            if (sum != magicNumber) {
                return false;
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += s.get(i).get(j);
            }
            if (sum != magicNumber) {
                return false;
            }
        }

        // check diagonals
        sum = 0;
        int sumReverseDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            sum += s.get(i).get(i);
            sumReverseDiagonal += s.get(2 - i).get(2 - i);
        }
        return sum == magicNumber && sumReverseDiagonal == magicNumber;
    }

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
    public void salesByMatch() throws Exception {
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
