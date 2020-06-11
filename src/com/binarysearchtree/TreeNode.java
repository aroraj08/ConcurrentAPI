package com.binarysearchtree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        this.data = data;
    }

    public int min() {

        if (this.leftChild == null) {
            return data;
        } else {
            return this.leftChild.min();
        }
    }

    public void insert(int value) {

        if (value == this.data) {
            // this is a duplicate value which is not supported by BST and hence will be ignored
            return;
        }
        if (value < this.data) {
            if (this.leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                this.leftChild.insert(value);
            }
        } else {
            if (this.rightChild == null) {
                this.rightChild = new TreeNode(value);
            } else {
                this.rightChild.insert(value);
            }
        }

    }

    public TreeNode get(int value) {

        if (value == this.data) {
            return this;
        }else if (value < this.data) {
            // search in left side of tree
            if (this.leftChild != null) {
                return this.leftChild.get(value);
            }
        } else {
            // search in right side of tree
            if (this.rightChild != null) {
                return this.rightChild.get(value);
            }
        }

        return null;
    }

    public void traverseInOrder() {

        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(" " + this.data);
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOrder() {

        System.out.print(" " + data);
        if (this.leftChild != null) {
            leftChild.traversePreOrder();
        }
        if (this.rightChild != null) {
            rightChild.traversePreOrder();
        }
    }

    public void traversePostOrder() {
        if (this.leftChild != null) {
            leftChild.traversePostOrder();
        }
        if (this.rightChild != null) {
            rightChild.traversePostOrder();
         }
        System.out.print(" " + data);
    }

    public void levelOrderTraversalUsingQueue() {

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(this);

        while (linkedList.size() != 0) {
            TreeNode node = linkedList.removeFirst();
            System.out.print(node.getData() + " ");
            if(node.leftChild != null ) {
                linkedList.add(node.leftChild);
            }
            if (node.rightChild != null) {
                linkedList.add(node.rightChild);
            }
        }
    }

    public int height() {

        if (this.leftChild == null && this.rightChild == null) {
            return 1;
        }

        int heightLeftSubtree = this.leftChild != null ? this.leftChild.height() : 0;
        int heightRightSubtree = this.rightChild != null ? this.rightChild.height() : 0;

       return heightLeftSubtree > heightRightSubtree ? heightLeftSubtree + 1 : heightRightSubtree + 1;

    }

    public void levelOrderTraversalRecursive() {
            int heightOfTree = this.height();
            for (int i=0; i< heightOfTree; i++) {
                printLevelOrderData(this, i, true);
            }
    }

    public void zigZagTraversalRecursive() {
        int heightOfTree = this.height();
        boolean isLeftToRight = true;

        for (int i=0; i< heightOfTree; i++) {
            printLevelOrderData(this, i, isLeftToRight);
            isLeftToRight = !isLeftToRight;
        }
    }

    private void printLevelOrderData(TreeNode node, int level, boolean isLeftToRight) {

        if (level == 0) {
            System.out.print(node.data + " ");
            return;
        }

        if (isLeftToRight) {
            if (node.leftChild != null) {
                printLevelOrderData(node.leftChild, level-1, isLeftToRight);
            }
            if (node.rightChild != null) {
                printLevelOrderData(node.rightChild, level-1, isLeftToRight);
            }
        } else {
            if (node.rightChild != null) {
                printLevelOrderData(node.rightChild, level-1, isLeftToRight);
            }
            if (node.leftChild != null) {
                printLevelOrderData(node.leftChild, level-1, isLeftToRight);
            }
        }

    }

    public void getToNode(int searchValue, List<Integer> path) {

        if (this.data == searchValue) {
            return;
        }
        if (searchValue < this.data && this.leftChild != null) {
            path.add(this.data);
            this.leftChild.getToNode(searchValue, path);
        } else if (searchValue > this.data && this.rightChild != null){
            path.add(this.data);
            this.rightChild.getToNode(searchValue, path);
        }
    }

    public void leftViewOfTree(int level, boolean isLevelParsed) {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {

        this.rightChild = rightChild;
    }
}
