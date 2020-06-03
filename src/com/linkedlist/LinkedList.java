package com.linkedlist;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public void add(T value)  {  // add element at beginning
        Node<T> node = new Node<>(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public Node<T> remove() {

        if (head == null) {
            throw new RuntimeException("Empty Linked List");
        } else {

            Node<T> removedNode = head;
            head = head.getNext();
            size--;
            removedNode.setNext(null);
            return removedNode;
        }
    }

     public T get() {
        return head == null ? null : head.getData();
     }

     public int getSize() {
        return size;
     }

    public T getMidElement() {

        if (head == null) {
            return null;
        } else if (this.size == 1) {
            return head.data;
        } else {

            Node<T> pointerOne = head;
            Node<T> pointerTwo = head;

            while (pointerTwo != null) {

                pointerTwo = pointerTwo.next;
                if (pointerTwo != null) {
                    pointerTwo = pointerTwo.next;
                    pointerOne = pointerOne.next;
                } else {
                    break;
                }
            }
            return  pointerOne.getData();
        }
    }
    static class Node<T> {

        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
