package org.learn.hr;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));

        int n = scan.nextInt();
        int[] resultArr = new int[3];

        for (int i = 0; i < n; i++) {
            int input = scan.nextInt();
            if (input > 0) {
                resultArr[0]++;
            } else if (input < 0) {
                resultArr[1]++;
            } else {
                resultArr[2]++;
            }
        }

        float fN = (float) n;
        System.out.println(String.format("%f%n%f%n%f%n",
                resultArr[0] / fN, resultArr[1] / fN, resultArr[2] / fN));


    }
}
