package org.learn.hr.javaArraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("javaArraylist.txt"));
        
        int n = scanner.nextInt();
        List<List<Integer>> inputLists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> currList = new ArrayList<>();

            int num = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                currList.add(scanner.nextInt());
            }

            inputLists.add(currList);
        }

        int numQueries = scanner.nextInt();
        for (int i = 0; i < numQueries; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            try {
                Integer query = inputLists.get(x - 1).get(y - 1);
                System.out.println(query);
            } catch (IndexOutOfBoundsException query) {
                System.out.println("ERROR!");
            }
        }
    }
}
