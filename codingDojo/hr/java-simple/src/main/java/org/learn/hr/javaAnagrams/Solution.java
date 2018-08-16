package org.learn.hr.javaAnagrams;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("javaAnagrams.txt"));
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }


    static boolean isAnagram(String a, String b) {
        StringBuilder remaining = new StringBuilder(b.toLowerCase());
        int i = 0;

        for (char c : a.toCharArray()) {
            i = remaining.indexOf(String.valueOf(c).toLowerCase());
            if (i == -1) {
                return false;
            } else {
                remaining.deleteCharAt(i);
            }
        }

        if (!remaining.toString().isEmpty()) {
            return false;
        }
        
        return true;
    }
}
