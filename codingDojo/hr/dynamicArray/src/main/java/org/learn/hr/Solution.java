package org.learn.hr;

import java.util.*;

public class Solution {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(ClassLoader.getSystemResourceAsStream("input.txt"));
        int numSeq = scanner.nextInt();
        int numQueries = scanner.nextInt();
        List<List<Integer>> sequences = initSequences(numSeq);

        performQueries(sequences, numQueries);
    }

    private static void performQueries(List<List<Integer>> sequences, int numQueries) {
        int lastAnswer = 0;

        for (int i = 0; i < numQueries; i++) {
            int type = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int seqIndex = (x ^ lastAnswer) % sequences.size();

            if (type == 1) {
                sequences.get(seqIndex).add(y);
            } else if (type == 2) {
                List<Integer> innerSeq = sequences.get(seqIndex);
                lastAnswer = innerSeq.get(y % innerSeq.size());
                System.out.println(lastAnswer);
            } else {
                System.err.println("invalid query type");
            }
        }
    }

    private static List<List<Integer>> initSequences(int numSeq) {
        List<List<Integer>> sequences = new ArrayList<>();

        for (int i = 0; i < numSeq; i++) {
            sequences.add(new ArrayList<>());
        }

        return sequences;
    }
}
