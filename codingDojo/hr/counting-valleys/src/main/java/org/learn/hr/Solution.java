package org.learn.hr;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        int height = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'U') {
                height++;
            } else if (s.charAt(i) == 'D') {
                height--;
                
                if (height == -1) {
                    valleyCount++;
                }
            }
        }

        return valleyCount;

    }

    private static final Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("in.txt"));

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
