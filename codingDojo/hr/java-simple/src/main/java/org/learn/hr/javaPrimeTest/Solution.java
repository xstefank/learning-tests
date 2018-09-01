package org.learn.hr.javaPrimeTest;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {


    private static final Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("javaPrime.txt"));

    public static void main(String[] args) {
        String n = scanner.nextLine();

        scanner.close();

        BigInteger i = new BigInteger(n);
        System.out.println(i.isProbablePrime(1) ? "prime" : "not prime");
    }

}
