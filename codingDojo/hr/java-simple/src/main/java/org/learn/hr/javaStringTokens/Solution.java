package org.learn.hr.javaStringTokens;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(ClassLoader.getSystemResourceAsStream("javaStringTokens.txt"));
        String input = scan.nextLine();
        scan.close();

        String[] split = input.split("[ !,?._'@]+");
        List<String> filtered = Arrays.stream(split).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered.size());
        for (String s : filtered) {
            System.out.println(s);
        }
    }
}
