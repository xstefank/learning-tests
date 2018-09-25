package org.learn.hr.javaDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("javaDeque.txt"));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int maxUniqueCount = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);

            if (deque.size() == m) {
                maxUniqueCount = Math.max(maxUniqueCount, set.size());
                Integer removal = deque.removeFirst();
                if (!deque.contains(removal)) {
                    set.remove(removal);
                }
            }
        }

        
        

        System.out.println(maxUniqueCount);
    }
}
