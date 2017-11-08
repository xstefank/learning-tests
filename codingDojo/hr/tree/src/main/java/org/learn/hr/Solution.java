package org.learn.hr;

public class Solution {

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
