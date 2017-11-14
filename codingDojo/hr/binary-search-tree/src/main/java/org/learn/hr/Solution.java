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

    static Node lca(Node node, int v1, int v2) {
        if (node.data < v1 && node.data < v2) {
            return lca(node.right, v1, v2);
        }

        if (node.data > v1 && node.data > v2) {
            return lca(node.left, v1, v2);
        }

        return node;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.data = 8;
        root.left = new Node();
        root.left.data = 4;
        root.left.right = new Node();
        root.left.right.data = 6;
        root.left.right.left = new Node();
        root.left.right.left.data = 5;
        root.left.left = new Node();
        root.left.left.data = 1;
        root.left.left.right = new Node();
        root.left.left.right.data = 2;
        root.left.left.right.right = new Node();
        root.left.left.right.right.data = 3;
        root.right = new Node();
        root.right.data = 9;

        System.out.println(lca(root, 1, 2).data);
    }


    private static class Node {

        int data;
        Node left;
        Node right;
    }
}
