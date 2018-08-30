package org.learn.hr.javaBigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String []args) {
        Scanner sc = new Scanner(ClassLoader.getSystemResourceAsStream("javaBigDecimal1.txt"));
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        List<String> list = Arrays.asList(s).stream().filter(Objects::nonNull).collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder(Comparator.comparing(s2 -> BigDecimal.valueOf(Double.parseDouble(s2)))));
        s = list.toArray(new String[s.length]);

        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }

    }
}
