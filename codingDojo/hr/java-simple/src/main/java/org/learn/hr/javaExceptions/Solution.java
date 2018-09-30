package org.learn.hr.javaExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("javaExceptions.txt"));

        try {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println(x / y);
        } catch (InputMismatchException e) {
            System.out.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getName() + (e.getMessage() != null ? ": " + e.getMessage() : ""));
        }
    }
}
