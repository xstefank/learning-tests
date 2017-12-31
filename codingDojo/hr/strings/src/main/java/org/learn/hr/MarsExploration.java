package org.learn.hr;

import java.util.Scanner;

public class MarsExploration {

    static int marsExploration(String s) {
        int wrongLetterCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int mod = i % 3;
            char c = s.charAt(i);
            if (mod == 0 || mod == 2) {
                if (c != 'S') {
                    wrongLetterCount++;
                }
            } else if (c != 'O') {
                wrongLetterCount++;
            }
        }

        return wrongLetterCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("mars-exploration/input1.txt"));
        String s = in.next();
        int result = marsExploration(s);
        System.out.println(result);
        in.close();
    }

}
