package org.learn.hr.javaStringReverse;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(ClassLoader.getSystemResourceAsStream("javaStringReverse.txt"));
        String s = sc.next();

        while (s.length() > 1) {
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                s = s.substring(1, s.length() - 1);
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
