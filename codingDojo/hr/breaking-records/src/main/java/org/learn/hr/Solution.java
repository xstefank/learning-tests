package org.learn.hr;

import java.util.Scanner;

public class Solution {

    static int[] getRecord(int[] s){
        int[] counts = new int[2];
        int highestValue = s[0];
        int lowestValue = s[0];

        for (int i = 1; i < s.length; i++) {
            if (s[i] > highestValue) {
                highestValue = s[i];
                counts[0]++;
            } else if (s[i] < lowestValue) {
                lowestValue = s[i];
                counts[1]++;
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input2.txt"));
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }

}
