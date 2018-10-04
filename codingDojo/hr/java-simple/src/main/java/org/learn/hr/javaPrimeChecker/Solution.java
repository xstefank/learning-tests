package org.learn.hr.javaPrimeChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Prime {
    void checkPrime(int... nums) {
        List<String> primes = new ArrayList<>();

        for (int num : nums) {
            if (isPrime(num)) {
                primes.add(String.valueOf(num));
            }
        }

        System.out.println(prettyPrintList(primes));
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        boolean isPrime = true;

        for (int div = 2; div <= num / 2; div++) {
            if (num % div == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    private String prettyPrintList(List<?> list) {
        if (list.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder(list.get(0).toString());
        for (int i = 1; i < list.size(); i++) {
            sb.append(" ").append(list.get(i).toString());
        }

        return sb.toString();
    }
}

public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("javaPrimeChecker.txt")));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i = 0; i < methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload = true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
