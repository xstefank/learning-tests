package org.learn.hr.javaStringsIntro;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(ClassLoader.getSystemResourceAsStream("javaStringsIntro1.txt"));
        String A = sc.next();
        String B = sc.next();

        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 1 ? "Yes" : "No");
        System.out.println(capitalizeFirstLetter(A) + " " + capitalizeFirstLetter(B));

    }

    private static String capitalizeFirstLetter(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

}
