package org.learn.hr;

public class Solution {

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+ " ");
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
