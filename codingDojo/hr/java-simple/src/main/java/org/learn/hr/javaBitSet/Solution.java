package org.learn.hr.javaBitSet;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private static BitSet b1;
    private static BitSet b2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("javaBitSet.txt"));
        int n = scanner.nextInt();

        b1 = new BitSet(n);
        b2 = new BitSet(n);

        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            String op = scanner.next();
            int in1 = scanner.nextInt();
            int in2 = scanner.nextInt();

            switch (op) {
                case "AND":
                    getSet(in1).and(getSet(in2));
                    outputResults();
                    break;
                case "OR":
                    getSet(in1).or(getSet(in2));
                    outputResults();
                    break;
                case "XOR":
                    getSet(in1).xor(getSet(in2));
                    outputResults();
                    break;
                case "FLIP":
                    getSet(in1).flip(in2);
                    outputResults();
                    break;
                case "SET":
                    getSet(in1).set(in2);
                    outputResults();
                    break;
                default:
                    System.err.println("Invalid input operand");
            }
        }
    }

    private static void outputResults() {
        System.out.println(b1.cardinality() + " " + b2.cardinality());
    }
    
    private static BitSet getSet(int in) {
        return (in == 1) ? b1 : b2;
    }
}
