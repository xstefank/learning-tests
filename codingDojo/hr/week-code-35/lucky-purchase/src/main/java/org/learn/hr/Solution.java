package org.learn.hr;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int n = in.nextInt();
        String bestLaptop = null;
        int bestPrice = Integer.MAX_VALUE;

        for(int a0 = 0; a0 < n; a0++){
            String name = in.next();
            int value = in.nextInt();

            if (isValidPrice(value)) {
                if (value < bestPrice) {
                    bestPrice = value;
                    bestLaptop = name;
                }
            }
        }

        System.out.println(bestLaptop != null ? bestLaptop : -1);

        in.close();
    }

    private static boolean isValidPrice(int value) {
        int count4 = 0;
        int count7 = 0;

        while (value > 0) {
            int mod10 = value % 10;
            if (mod10 == 4) {
                count4++;
                value /= 10;
            } else if (mod10 == 7) {
                count7++;
                value /=10;
            } else {
                return false;
            }
        }

        return count4 == count7;
    }
}
