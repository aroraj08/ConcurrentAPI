package com.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println(linkedList.getSize());

        linkedList.printLinkedList();
        System.out.println("----");

        linkedList.reverseLinkedList();

        /*
        // search for mid element

        linkedList.remove();

        linkedList.remove();
        linkedList.remove();
        System.out.println(linkedList.getSize());

        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);

        Integer val = linkedList.getMidElement();
        System.out.println(val);*/
    }
}
