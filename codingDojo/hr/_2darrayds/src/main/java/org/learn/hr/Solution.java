package org.learn.hr;

import java.util.Scanner;

public class Solution {

    private static final int SIZE = 6;
    private static final int HR_NUM = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));

        int[][] array2D = new int[SIZE][SIZE];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                array2D[i][j] = scanner.nextInt();
            }
        }

        int maxHRSum = Integer.MIN_VALUE;

        for (int i = 0; i < HR_NUM; i++) {
            for (int j = 0; j < HR_NUM; j++) {
                int currentHRSum = hourglassSum(array2D, i, j);
                if (currentHRSum > maxHRSum) {
                    maxHRSum = currentHRSum;
                }
            }
        }

        System.out.println(maxHRSum);
    }

    private static int hourglassSum(int[][] array, int arrI, int arrJ) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j == 1) {
                    sum += array[arrI + i][arrJ + j];
                }
            }
        }

        return sum;
    }
}
