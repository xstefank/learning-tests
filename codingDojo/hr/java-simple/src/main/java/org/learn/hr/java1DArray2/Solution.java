package org.learn.hr.java1DArray2;

import java.util.Scanner;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        return canWin(leap, game, 0);
    }

    private static boolean canWin(int leap, int[] game, int curr) {
        if (curr < 0 || game[curr] == 1) {
            return false;
        }

        if ((curr == game.length - 1) || (curr + leap > game.length - 1)) {
            return true;
        }
        
        game[curr] = 1;
        return canWin(leap, game, curr + 1) || canWin(leap, game, curr - 1) || canWin(leap, game, curr + leap);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("java1DArray2.txt"));
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
