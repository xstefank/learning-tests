package org.learn.hr;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();

        long[] array = new long[n];
        long max = 0;

        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();

            array[a - 1] += k;
            if (b < n) {
                array[b] -= k;
            }
        }
        in.close();

        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += array[i];
            if (temp > max) {
                max = temp;
            }
        }

        System.out.println(max);
    }

}
