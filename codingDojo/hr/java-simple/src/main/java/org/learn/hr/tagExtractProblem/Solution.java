package org.learn.hr.tagExtractProblem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    
    private static final Pattern tagPattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
    
    public static void main(String[] args){

        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("tagExctractProblem.txt"));
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            Matcher matcher = tagPattern.matcher(line);

            boolean matchFound = false;
            while (matcher.find()) {
                System.out.println(matcher.group(2));
                matchFound = true;
            }

            if (!matchFound) {
                System.out.println("None");
            }

            testCases--;
        }
    }
}
