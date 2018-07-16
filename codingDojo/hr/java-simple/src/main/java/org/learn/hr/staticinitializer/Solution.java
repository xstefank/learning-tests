package org.learn.hr.staticinitializer;

import java.util.Scanner;

public class Solution {

    private static boolean flag;
    private static int B;
    private static int H;

    static {
        Scanner scanner = new Scanner(Solution.class.getClassLoader().getResourceAsStream("staticinitializer2.txt"));
        B = scanner.nextInt();
        H = scanner.nextInt();

        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            flag = true;
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.println(area);
        }
    }
}
