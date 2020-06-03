package com.binarysearchtree;

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
