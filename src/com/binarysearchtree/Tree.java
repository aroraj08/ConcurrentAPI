package com.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public void zigZagTraversalUsingStack(){
        if(root==null){
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode node = s1.pop();
                System.out.print(node.getData()+" ");
                if(node.getRightChild()!=null){
                    s2.push(node.getRightChild());
                }
                if(node.getLeftChild()!=null){
                    s2.push(node.getLeftChild());
                }
            }
            while(!s2.isEmpty()){
                TreeNode node = s2.pop();
                System.out.print(node.getData()+" ");
                if(node.getLeftChild()!=null){
                    s1.push(node.getLeftChild());
                }
                if(node.getRightChild()!=null){
                    s1.push(node.getRightChild());
                }
            }
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
