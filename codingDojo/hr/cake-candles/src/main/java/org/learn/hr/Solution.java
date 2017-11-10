package org.learn.hr;

import java.util.Scanner;

public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        int tallestHeight = Integer.MIN_VALUE;
        int tallestCount = 0;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > tallestHeight) {
                tallestHeight = ar[i];
                tallestCount = 1;
            } else if (ar[i] == tallestHeight) {
                tallestCount++;
            }
        }

        return tallestCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}

