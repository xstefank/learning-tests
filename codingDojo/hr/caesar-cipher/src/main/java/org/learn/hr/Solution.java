package org.learn.hr;

import java.util.Scanner;

public class Solution {

    private static final int ALPHABET_SIZE = 26;

    static String caesarCipher(String s, int k) {
        k = k % ALPHABET_SIZE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char a = c;
            if (Character.isLetter(c)) {
                a = (char) (c + k);
                if ((Character.isLowerCase(c) && a > 'z')
                        || (Character.isUpperCase(c) && a > 'Z')) {
                    a = (char) (c - (ALPHABET_SIZE - k));
                }
            }

            sb.append(a);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input0.txt"));
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }

}
