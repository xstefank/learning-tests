package org.learn.hr;

import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("inputCamelCase.txt"));
        String s = in.next();


        int upperCaseCount = countUpperCaseLetters(s);
        System.out.println(upperCaseCount == 0 ? 1 : upperCaseCount + 1);
    }

    private static int countUpperCaseLetters(String s) {
        return (int) s.chars().filter(Character::isUpperCase).count();
    }
}
