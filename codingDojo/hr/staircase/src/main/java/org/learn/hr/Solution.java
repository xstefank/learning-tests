package org.learn.hr;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int n = scanner.nextInt();

        for (int i = n - 1; i >= 0; i--) {
            System.out.println(repeatN(" ", i) + repeatN("#", n - i));
        }

    }

    private static String repeatN(String s, int n) {
        return String.join("", Collections.nCopies(n, s));
    }

}
