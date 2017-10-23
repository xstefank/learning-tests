package org.learn.hr;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int scoreA = 0;
    private static int scoreB = 0;

    static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        comperaSingleScore(a0, b0);
        comperaSingleScore(a1, b1);
        comperaSingleScore(a2, b2);

        return new int[]{scoreA, scoreB};
    }

    private static void comperaSingleScore(int a, int b) {
        int temp;
        if ((temp = compare(a, b)) != 0) {
            if (temp > 0) {
                scoreA++;
            } else {
                scoreB++;
            }
        }
    }

    private static int compare(int a, int b) {
        if (a == b) return 0;
        return a > b ? 1 : -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


    }
}

