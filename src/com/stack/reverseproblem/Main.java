package com.stack.reverseproblem;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.size());
        stack.printList();

        reverseStack(stack);
        stack.printList();
    }


    private static void reverseStack(Stack<Integer> stack) {

        if (stack == null || stack.size() == 0) {
            return;
        }
        Integer val = stack.pop();
        reverseStack(stack);

        insertAtBottom(stack, val);
    }

    private static  void insertAtBottom(Stack<Integer> stack, Integer val) {
        if (stack.size() == 0) {
            stack.push(val);
        } else {
            Integer a = stack.pop();

            insertAtBottom(stack, val);
            stack.push(a);
        }
    }
}
