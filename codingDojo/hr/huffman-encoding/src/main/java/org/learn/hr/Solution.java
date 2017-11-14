package org.learn.hr;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Character, Integer> frequencies = new HashMap<>();

    static void decode(String s, Node root) {
        StringBuilder inputBuilder = new StringBuilder(s);
        StringBuilder decodedBuilder = new StringBuilder();

        while (inputBuilder.length() > 0) {
            char nextChar = getNextChar(inputBuilder, root);
            decodedBuilder.append(nextChar);
        }

        System.out.println(decodedBuilder.toString());
    }

    private static char getNextChar(StringBuilder inputBuilder, Node root) {
        Node current = root;

        while (!isLeaf(current)) {
            if (inputBuilder.charAt(0) == '1') {
                current = current.right;
            } else if (inputBuilder.charAt(0) == '0') {
                current = current.left;
            }

            inputBuilder = inputBuilder.deleteCharAt(0);
        }

        return current.data;
    }

    private static boolean isLeaf(Node current) {
        return current.left == null && current.right == null;
    }

    public static void main(String[] args) {
        String s = "1001011";

        Node root = new Node();
        root.data = '0';
        root.frequency = 5;
        root.left = new Node();
        root.left.data = '0';
        root.left.frequency = 2;
        root.left.left = new Node();
        root.left.left.data = 'B';
        root.left.left.frequency = 1;
        root.left.right = new Node();
        root.left.right.data = 'C';
        root.left.right.frequency = 1;
        root.right = new Node();
        root.right.data = 'A';
        root.right.frequency = 3;

        decode(s, root);

    }


    private static class Node {
        public int frequency;
        public char data;
        public Node left, right;
    }
}
