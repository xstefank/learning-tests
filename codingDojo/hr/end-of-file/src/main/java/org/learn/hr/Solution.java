package org.learn.hr;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int lineNumber = 0;

        while (scanner.hasNextLine()) {
            System.out.println(++lineNumber + " " + scanner.nextLine());
        }
    }
}
