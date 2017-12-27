package org.learn.hr;

import java.util.Scanner;

public class Solution {

    static int solve(int n, int[] s, int d, int m){
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i + m > n) {
                break;
            }
            if (sum(s, i, m) == d) {
                count++;
            }
        }

        return count;
    }

    private static int sum(int[] arr, int start, int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += arr[start + i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input2.txt"));
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }

}
