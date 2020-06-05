package com.stack.reverseproblem;


import java.util.Iterator;
import java.util.LinkedList;

public class Stack<Integer> {

    private LinkedList<Integer> linkedList;
    private int size;
    public Stack() {
        this.linkedList = new LinkedList<>();
    }

    public void push(Integer value) {
       this.linkedList.addLast(value);
    }

    public Integer pop() {
        return this.linkedList.removeLast();
    }

    public Integer peek() {
        return this.linkedList.peek();
    }

    public int size() {
        return  this.linkedList.size();
    }

    public void printList() {
        Iterator<Integer> it = this.linkedList.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
