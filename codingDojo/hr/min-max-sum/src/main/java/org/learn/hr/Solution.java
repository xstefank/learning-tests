package org.learn.hr;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        long sum = sumValues(arr);
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;


        for (int i = 0; i < arr.length; i++) {
            long sumExceptI = sum - arr[i];

            if (sumExceptI > max) {
                max = sumExceptI;
            }

            if (sumExceptI < min) {
                min = sumExceptI;
            }
        }

        System.out.printf("%d %d", min, max);
    }

    private static long sumValues(int[] arr) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
