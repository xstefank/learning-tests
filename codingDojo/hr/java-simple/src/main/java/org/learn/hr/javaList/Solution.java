package org.learn.hr.javaList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("javaList.txt"));

        int n = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.addLast(scanner.nextInt());
        }

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            if (scanner.next().equals("Insert")) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                list.add(x, y);
            } else {
                int x = scanner.nextInt();

                list.remove(x);
            }
        }

        for (Iterator<Integer> it = list.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
    }
}
