package org.learn.hr;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] argh) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            printSequenceSums(a, b, n);
        }
        in.close();
    }

    private static void printSequenceSums(int a, int b, int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", computeSequence(a, b, i));
        }
        System.out.println();
    }

    static int computeSequence(int a, int b, int n) {
        return a + IntStream.range(0, n + 1)
                .map(i -> (int) Math.pow(2, i) * b)
                .sum();
    }
}

