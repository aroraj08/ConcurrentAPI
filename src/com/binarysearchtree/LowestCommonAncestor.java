package com.binarysearchtree;

import java.util.Arrays;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        int node1Value = 10;
        int node2Value = 22;

        Tree tree = new Tree();
        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
        tree.insert(12);
        tree.insert(10);
        tree.insert(14);
        tree.insert(22);

        //tree.levelOrderTraversal(true);

        Integer[] node1Path = tree.getToNodeWithValue(node1Value);
        Integer[] node2Path = tree.getToNodeWithValue(node2Value);


        Arrays.stream(node1Path)
                .forEach(System.out :: println);

        System.out.println("----");
        Arrays.stream(node2Path)
                .forEach(System.out :: println);
    }
}
