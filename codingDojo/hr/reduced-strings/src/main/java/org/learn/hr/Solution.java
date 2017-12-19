package org.learn.hr;

import java.util.Scanner;

public class Solution {

    static String super_reduced_string(String s) {

        if (s.length() <= 1) {
            return s;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                return super_reduced_string(output.toString() + s.substring(i + 2));
            } else {
                output.append(s.charAt(i));
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input1.txt"));
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result.isEmpty() ? "Empty String" : result);
    }

}
