package org.learn.hr;

import java.util.Scanner;

public class Solution {

    static void tripleRecursion(int n, int m, int k) {
        int array[][] = new int[n][n];
        array[0][0] = m;
        print(0, 1, n, k, array);
        print(1, 1, n, k, array);
        print(1, 0, n, k, array);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                printElement(array[i][j]);
            }
            System.out.println();
        }
    }

    private static void print(int i, int j, int n, int k, int[][] array) {
        if (i >= n || j >= n) {
            return;
        }

        if (i == j) {
            array[i][j] = array[i - 1][j - 1] + k;
        } else if (i > j) {
            array[i][j] = array[i - 1][j] - 1;
        } else if (i < j) {
            array[i][j] = array[i][j - 1] - 1;
        }

        print(i, j + 1, n, k, array);
        print(i + 1, j + 1, n, k, array);
        print(i + 1, j, n, k, array);
    }

    private static void printElement(int m) {
        System.out.printf("%d ", m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        tripleRecursion(n, m, k);
        in.close();
    }
}
