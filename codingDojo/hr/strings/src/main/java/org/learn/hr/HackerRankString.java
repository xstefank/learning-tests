package org.learn.hr;

import java.util.Scanner;

public class HackerRankString {

    private static final String HACKERRANK = "hackerrank";

    static String hackerrankInString(String s) {
        char[] hackerRankLetters = HACKERRANK.toCharArray();
        int current = 0;

        for (int i = 0; i < hackerRankLetters.length; i++) {
            while (current < s.length() && s.charAt(current) != hackerRankLetters[i]) {
                current++;
            }

            if (current == s.length()) {
                return "NO";
            }

            current++;
        }

        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("inputHackerRankString.txt"));
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }
}
