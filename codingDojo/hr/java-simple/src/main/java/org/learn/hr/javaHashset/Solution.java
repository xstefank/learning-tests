package org.learn.hr.javaHashset;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(ClassLoader.getSystemResourceAsStream("javaHashset.txt"));
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<Map.Entry<String, String>> pairSet = new HashSet<>();
        
        for (int i = 0; i < t; i++) {
            pairSet.add(new AbstractMap.SimpleEntry<>(pair_left[i], pair_right[i]));
            System.out.println(pairSet.size());
        }
    }
}
