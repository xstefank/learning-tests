package org.learn.hr;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    static void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+ " ");
    }

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.data = 1;
        root.left = new Node();
        root.left.data = -1;
        root.left.right = new Node();
        root.left.right.data = -2;
        root.left.right.left = new Node();
        root.left.right.left.data = -3;
        root.left.right.left.left = new Node();
        root.left.right.left.left.data = -4;
        root.right = new Node();
        root.right.data = 2;
        root.right.right = new Node();
        root.right.right.data = 5;
        root.right.right.left = new Node();
        root.right.right.left.data = 3;
        root.right.right.left.right = new Node();
        root.right.right.left.right.data = 4;
        root.right.right.right = new Node();
        root.right.right.right.data = 6;

        topView(root);
    }

    static void topView(Node root) {
        if (root == null) {
            return;
        }

        LinkedList<Node> topViewList = new LinkedList<>();

        topViewList.addFirst(root);
        Node current = root.left;

        while (current != null) {
            topViewList.addFirst(current);
            current = current.left;
        }

        current = root.right;

        while (current != null) {
            topViewList.addLast(current);
            current = current.right;
        }

        topViewList.forEach(Solution::printNode);
    }

    private static void printNode(Node node) {
        System.out.printf("%d ", node.data);
    }

    static void correctTopView(Node root) {
        if (root == null) {
            return;
        }

        Map<Integer, Queue<Node>> verticalDistanceMap = computeVerticalDistanceMap(root);
        Queue<Node> levelTraversal = computeLevelTraversal(root);

        verticalDistanceMap = verticalDistanceMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        printTopView(verticalDistanceMap, levelTraversal);

    }

    private static void printTopView(Map<Integer, Queue<Node>> verticalDistanceMap, Queue<Node> levelTraversal) {
        verticalDistanceMap.forEach((key, nodeQueue) -> {
            if (nodeQueue.size() == 1) {
                printNode(nodeQueue.peek());
            } else {
                printNode(findFirst(nodeQueue, levelTraversal));
            }
        });
    }

    private static Node findFirst(Queue<Node> nodeQueue, Queue<Node> levelTraversal) {
        for (Node node : levelTraversal) {
            if (node == nodeQueue.peek()) {
                return node;
            }
        }

        return null;
    }

    private static Queue<Node> computeLevelTraversal(Node root) {
        Queue<Node> output = new ArrayDeque<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                output.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return output;
    }

    private static Map<Integer, Queue<Node>> computeVerticalDistanceMap(Node root) {
        Map<Integer, Queue<Node>> verticalDistances = new HashMap<>();

        Queue<Node> rootQueue = new ArrayDeque<>();
        rootQueue.add(root);
        verticalDistances.put(0, rootQueue);

        computeVerticalDistance(root.left, -1, verticalDistances);
        computeVerticalDistance(root.right, 1, verticalDistances);

        return verticalDistances;

    }

    private static void computeVerticalDistance(Node node, int column, Map<Integer, Queue<Node>> verticalDistances) {
        if (node == null) {
            return;
        }

        Queue<Node> vericalDistance = verticalDistances.get(column);
        if (vericalDistance == null) {
            Queue<Node> nodeQueue = new ArrayDeque<>();
            nodeQueue.add(node);
            verticalDistances.put(column, nodeQueue);
        } else {
            vericalDistance.add(node);
        }

        computeVerticalDistance(node.left, column - 1, verticalDistances);
        computeVerticalDistance(node.right, column + 1, verticalDistances);
    }

    static void levelOrder(Node root) {
        Queue<Node> levelTraversal = computeLevelTraversal(root);

        levelTraversal.forEach(Solution::printNode);
    }

    private static class Node {
        int data;
        Node left;
        Node right;
    }
}
