package org.learn.hr;

import java.util.Scanner;
import java.util.function.Function;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }

        System.out.println(computeDiagonalDifference(a));
    }

    private static int computeDiagonalDifference(int[][] array) {

        int primDiagSum = computePrimaryDiagonalSum(array);
        int secDiagSum = computeSecondaryDiagonalSum(array);

        return Math.abs(primDiagSum - secDiagSum);
    }

    private static int computePrimaryDiagonalSum(int[][] array) {
        return computeDiagonalSum(array, x -> x);
    }

    private static int computeSecondaryDiagonalSum(int[][] array) {
        return computeDiagonalSum(array, x -> array.length - x - 1);
    }

    private static int computeDiagonalSum(int[][] array, Function<Integer, Integer> diagFun) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][diagFun.apply(i)];
        }

        return sum;
    }
}
