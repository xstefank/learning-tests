package org.learn.hr;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }

        printFruit(s, t, a, apple);
        printFruit(s, t, b, orange);
    }

    private static void printFruit(int s, int t, int a, int[] apple) {
        int count = 0;

        for (int distance : apple) {
            int position = a + distance;
            if (isValidPosition(position, s, t)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isValidPosition(int position, int s, int t) {
        return position >= s && position <= t;
    }
}
