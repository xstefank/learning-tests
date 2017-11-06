package org.learn.hr;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));

        int numStrings = scan.nextInt();
        String[] strings = new String[numStrings];

        scan.nextLine();

        loadStringArray(scan, numStrings, strings);

        int numQueries = scan.nextInt();
        String[] queries = new String[numQueries];

        scan.nextLine();

        loadStringArray(scan, numQueries, queries);

        for (int i = 0; i < numQueries; i++) {
            int count = countOccurences(queries[i], strings);
            System.out.println(count);
        }
    }

    private static int countOccurences(String query, String[] strings) {
        return (int) Arrays.stream(strings).filter(s -> s.equals(query)).count();
    }

    private static void loadStringArray(Scanner scan, int n, String[] array) {
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextLine();
        }
    }
}
