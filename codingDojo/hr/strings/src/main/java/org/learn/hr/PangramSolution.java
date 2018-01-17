package org.learn.hr;

import java.util.Arrays;
import java.util.Scanner;

public class PangramSolution {

    private static final int ALPHABET_SIZE = 26;
    private static final int A_INDEX = 97;

    private static final char[] alphabet = new AlphabetSupplier().getAlphabet();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("pangram/pangramInvalid.txt"));
        String s = scanner.nextLine();

        System.out.println(isPangram(s) ? "pangram" : "not pangram");
    }

    private static boolean isPangram(String s) {
        int currentIndex = 0;
        boolean[] matched = new boolean[ALPHABET_SIZE];
        int matchedCount = 0;

        while (currentIndex < s.length()) {
            char currentLetter = Character.toLowerCase(s.charAt(currentIndex));
            if (Character.isLetter(currentLetter)) {
                int index = (int) currentLetter - A_INDEX;
                if (!matched[index]) {
                    matched[index] = true;
                    if (++matchedCount == ALPHABET_SIZE) {
                        return true;
                    }
                }
            }
            currentIndex++;
        }

        return false;
    }

    private static class AlphabetSupplier {

        private static char[] alphabet;

        public char[] getAlphabet() {
            if (alphabet == null) {
                alphabet = new char[ALPHABET_SIZE];
                for (int i = A_INDEX; i < A_INDEX + ALPHABET_SIZE; i++) {
                    alphabet[i - A_INDEX] = (char) i;
                }
            }

            return Arrays.copyOf(alphabet, alphabet.length);
        }
    }
}
