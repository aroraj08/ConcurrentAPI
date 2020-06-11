package com.binarysearchtree;

public class LeftViewTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(15);
        tree.insert(5);
        tree.insert(20);
        tree.insert(1);
        tree.insert(8);
        tree.insert(17);
        tree.insert(25);
        tree.insert(23);
        tree.insert(28);

        tree.levelOrderTraversal(false);
        System.out.println("");
        tree.leftViewTree();
    }
}
