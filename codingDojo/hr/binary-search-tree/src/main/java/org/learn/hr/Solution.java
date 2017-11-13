package org.learn.hr;

public class Solution {

    static Node insert(Node node,int value) {
        if (node == null) {
            return newNode(value);
        }

        if (value < node.data) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                node.left = newNode(value);
            }
        } else {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                node.right = newNode(value);
            }
        }

        return node;
    }

    private static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        return node;
    }


    private static class Node {

        int data;
        Node left;
        Node right;
    }
}
