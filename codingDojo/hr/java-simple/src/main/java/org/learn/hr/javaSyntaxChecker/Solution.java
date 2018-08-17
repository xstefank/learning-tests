package org.learn.hr.javaSyntaxChecker;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Solution {

    public static void main(String[] args){
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("javaSyntaxChecker.txt"));
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();

            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException ex) {
                System.out.println("Invalid");
            }
            
            testCases--;
        }
    }
}
