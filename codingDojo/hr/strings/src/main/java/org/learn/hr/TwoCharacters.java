package org.learn.hr;

import java.util.Scanner;

public class TwoCharacters {

    private static final int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        Scanner in = new Scanner(ClassLoader.getSystemResourceAsStream("inputTwoCharacters.txt"));
        int len = in.nextInt();
        String s = in.next();

        char [][] letters = new char[ALPHABET_SIZE][ALPHABET_SIZE];
        int [][] values = new int[ALPHABET_SIZE][ALPHABET_SIZE];
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            for(int i = 0; i < ALPHABET_SIZE; i++) {
                if(letters[index][i] != c && values[index][i] != -1) {
                    letters[index][i] = c;
                    ++values[index][i];
                } else {
                    values[index][i] = -1;
                }
                if(letters[i][index] != c && values[i][index] != -1) {
                    letters[i][index] = c;
                    ++values[i][index];
                } else {
                    values[i][index] = -1;
                }
            }
        }
        int largestString = 0;
        for(int i = 0; i < ALPHABET_SIZE; i++) {
            for(int j = 0; j < ALPHABET_SIZE; j++) {
                if(values[i][j] > largestString) {
                    largestString = values[i][j];
                }
            }
        }

        System.out.println(largestString > 1 ? largestString : 0);


    }

}
