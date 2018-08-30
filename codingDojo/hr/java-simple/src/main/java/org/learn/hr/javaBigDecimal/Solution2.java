package org.learn.hr.javaBigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution2 {

    public static void main(String []args) {
        Scanner sc = new Scanner(ClassLoader.getSystemResourceAsStream("javaBigDecimal1.txt"));
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        s = Arrays.copyOf(s, n);

        Arrays.sort(s, Collections.reverseOrder(Comparator.comparing(i -> BigDecimal.valueOf(Double.parseDouble(i)))));

        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }

    }
}
