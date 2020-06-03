package com.binarysearchtree;

public class Main {

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
        tree.insert(15);

        tree.inOrderTraversal();
        System.out.println();

        System.out.println(tree.get(1).getData());
        System.out.println(tree.get(23).getData());
        System.out.println(tree.get(15).getData());
        System.out.println(tree.get(2) == null ? null : tree.get(2).getData());

        System.out.println(tree.min());

        tree.preOrderTraversal();
        System.out.println();
        tree.postOrderTraversal();
    }
}
