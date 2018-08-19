package org.learn.hr.validUsernameChecker;

import java.util.Scanner;

public class Solution {
    private static final Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("validUsernameChecker1.txt"));

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
