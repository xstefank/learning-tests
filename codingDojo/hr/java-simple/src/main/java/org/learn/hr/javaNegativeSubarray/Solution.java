package org.learn.hr.javaNegativeSubarray;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        int negSumsCount = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int subArrSum = computeSubarraySum(i, j, arr);
                if (subArrSum < 0) {
                    negSumsCount++;
                }
            }
        }

        System.out.println(negSumsCount);
    }

    private static int computeSubarraySum(int from, int to, int[] arr) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += arr[i];
        }
        
        return sum;
    }
}
