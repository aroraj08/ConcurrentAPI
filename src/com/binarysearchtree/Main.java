package com.binarysearchtree;

import com.linkedlist.LinkedList;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(15);
        System.out.println("--------------------------");
        System.out.println(tree.height());

        tree.insert(5);
        tree.insert(20);
        System.out.println("--------------------------");
        System.out.println(tree.height());

        tree.insert(1);
        tree.insert(8);
        tree.insert(17);
        System.out.println("--------------------------");
        System.out.println(tree.height());
        tree.insert(25);
        tree.insert(23);
        System.out.println("--------------------------");
        System.out.println(tree.height());
        tree.insert(28);
        System.out.println("|--------------------------|");
        System.out.println(tree.height());

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
        System.out.println();

        System.out.println("--------------------------");
        // level order traversal of tree
        tree.levelOrderTraversal(true);
        System.out.println();
        tree.levelOrderTraversal(false);

        System.out.println();
        tree.zigZagTraversal();

        System.out.println("zig zag traversal using two stacks");
        tree.zigZagTraversalUsingStack();
    }

}
