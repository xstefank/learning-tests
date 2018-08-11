package org.learn.hr.javaCurrencyFormatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("currencyPayment1.txt"));
        double payment = scanner.nextDouble();
        scanner.close();

        String us = getFormattedPayment(Locale.US, payment);
        String india = getFormattedPayment(new Locale("en", "IN"), payment);
        String china = getFormattedPayment(Locale.CHINA, payment);
        String france = getFormattedPayment(Locale.FRANCE, payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }

    private static String getFormattedPayment(Locale locale, double payment) {
        NumberFormat paymentFormat = NumberFormat.getCurrencyInstance(locale);
        return paymentFormat.format(payment);
    }

}
