package org.learn.hr.javaLambdas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    
    PerformOperation isOdd() {
        return (n) -> n % 2 == 1;
    }
    
    PerformOperation isPrime() {
        return (n) -> {
            boolean isPrime = true;
            for(int divisor = 2; divisor <= n / 2; divisor++) {
                if (n % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }

            return isPrime;
        };
    }
    
    PerformOperation isPalindrome() {
        return (int n) -> Integer.toString(n).equals(new StringBuilder(Integer.toString(n)).reverse().toString());
    }

}


public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("javaLambdas.txt")));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
