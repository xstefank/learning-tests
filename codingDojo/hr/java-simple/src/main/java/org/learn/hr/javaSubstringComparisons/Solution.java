package org.learn.hr.javaSubstringComparisons;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("javaSubstringComparisons.txt"));
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String currentSubstring = s.substring(0, k);

        String smallest = currentSubstring;
        String largest = currentSubstring;

        int i = 1;
        while (i + k <= s.length()) {
            currentSubstring = s.substring(i, i + k);

            if (currentSubstring.compareTo(smallest) < 0) {
                smallest = currentSubstring;
            }

            if (currentSubstring.compareTo(largest) > 0) {
                largest = currentSubstring;
            }
            
            i++;
        }

        return smallest + "\n" + largest;
    }
}
