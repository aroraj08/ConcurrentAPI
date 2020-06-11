package com.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            this.root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void inOrderTraversal() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
           return root.get(value);
        }
        return null;
    }

    public int min(){
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public void preOrderTraversal() {
        if (root == null) {
            return;
        }
        root.traversePreOrder();
    }

    public void postOrderTraversal() {
        if (root == null) {
            return;
        }
        root.traversePostOrder();
    }

    public void levelOrderTraversal(boolean useRecursion) {

        if (useRecursion) {
            root.levelOrderTraversalRecursive();
        } else {
            root.levelOrderTraversalUsingQueue();
        }
    }

    public void zigZagTraversal() {
        root.zigZagTraversalRecursive();
    }
    public int height() {

        if (root == null) {
            return 0;
        }
        return root.height();
    }

    public Integer[] getToNodeWithValue(int searchValue) {

        // start from root and reach the node with value as incoming value
            if (root.getData() == searchValue) {
                return new Integer[]{searchValue};
            } else {
                List<Integer> path = new ArrayList<>();
                root.getToNode(searchValue, path);
                return path.toArray(new Integer[path.size()]);
            }
    }

    public void leftViewTree() {
        for (int i=0; i<this.height(); i++) {
            root.leftViewOfTree(i, false);
        }
    }
}
