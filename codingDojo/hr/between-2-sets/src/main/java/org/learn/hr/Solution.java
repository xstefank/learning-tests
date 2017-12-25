package org.learn.hr;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int getTotalX(int[] a, int[] b) {
        int betweenCount = 0;
        int minValue = Arrays.stream(a).max().getAsInt();
        int maxValue = Arrays.stream(b).min().getAsInt();

        for (int i = minValue; i <= maxValue; i++) {
            if (isDividedByAll(i, a) && dividesAll(i, b)) {
                betweenCount++;
            }
        }

        return betweenCount;
    }

    private static boolean dividesAll(int n, int[] a) {
        boolean res = true;

        for (int i : a) {
            res = res && (i % n == 0);
        }

        return res;
    }

    private static boolean isDividedByAll(int n, int[] a) {
        boolean res = true;

        for (int i : a) {
            res = res && (n % i == 0);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }

}
