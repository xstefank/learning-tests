package org.learn.hr.javaVistiorPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    
    private int leafSum = 0;
    
    public int getResult() {
        return leafSum;
    }

    public void visitNode(TreeNode node) {
        //noop
    }

    public void visitLeaf(TreeLeaf leaf) {
        leafSum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    
    private long redProduct = 1;
    
    public int getResult() {
        return (int) redProduct;
    }

    public void visitNode(TreeNode node) {
        checkNode(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        checkNode(leaf);
    }

    private void checkNode(Tree node) {
        if (node.getColor() == Color.RED) {
            redProduct = (redProduct * node.getValue()) % 1000000007;
        }
    }
}

class FancyVisitor extends TreeVis {
    
    private int sumNonLeafEvenLength = 0;
    private int sumGreenLeafs = 0;
    
    public int getResult() {
        return Math.abs(sumNonLeafEvenLength - sumGreenLeafs);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumNonLeafEvenLength += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumGreenLeafs += leaf.getValue();
        }
    }
}

public class Solution {

    private static Map<Integer, Set<Integer>> neighborSets;
    private static int[] values;
    private static Color[] colors;

    public static Tree solve() {
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream("javaVisitorPattern2.txt"));
        int n = scanner.nextInt();

        values = new int[n];
        colors = new Color[n];
        
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (scanner.nextInt() == 0) {
                colors[i] = Color.RED;
            } else {
                colors[i] = Color.GREEN;
            }
        }

        neighborSets = new HashMap<>();

        for (int j = 0; j < n - 1; j++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            // edges are unoriented
            addNeighbors(neighborSets, from, to);
            addNeighbors(neighborSets, to, from);
        }
        
        scanner.close();

        if (n == 1) {
            return new TreeLeaf(values[0], colors[0], 0);
        }

        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }

    private static void addChildren(TreeNode node, int num) {
        for (Integer childNum : neighborSets.get(num)) {
            neighborSets.get(childNum).remove(num);

            Set<Integer> childNeighbors = neighborSets.get(childNum);
            
            Tree childNode = null;
            if (childNeighbors != null && !childNeighbors.isEmpty()) {
                childNode = new TreeNode(values[childNum - 1], colors[childNum - 1], node.getDepth() + 1);
            } else {
                childNode = new TreeLeaf(values[childNum - 1], colors[childNum - 1], node.getDepth() + 1);
            }
            
            node.addChild(childNode);

            if (childNode instanceof TreeNode) {
                addChildren((TreeNode) childNode, childNum);
            }
        }
    }

    private static void addNeighbors(Map<Integer, Set<Integer>> neighborSets, int from, int to) {
        Set<Integer> neighbors = neighborSets.get(from);
        if (neighbors == null) {
            neighbors = new HashSet<>();
            neighborSets.put(from, neighbors);
        }

        neighbors.add(to);
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
