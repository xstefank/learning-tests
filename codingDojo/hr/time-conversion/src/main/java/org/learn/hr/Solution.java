package org.learn.hr;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static String timeConversion(String s) {
        String[] parts = s.split(":");
        int hours = Integer.valueOf(parts[0]);
        int minutes = Integer.valueOf(parts[1]);
        int seconds = Integer.valueOf(parts[2].substring(0, 2));
        String timeSpec = parts[2].substring(2);

        if ("AM".equals(timeSpec)) {
            if (hours == 12) {
                hours -= 12;
            }
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else if ("PM".equals(timeSpec)) {
            int newHours = Integer.valueOf(parts[0]) + 12;
            return String.format("%02d:%02d:%02d", newHours == 24 ? 12 : newHours, minutes, seconds);
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
