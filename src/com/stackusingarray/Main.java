package com.stackusingarray;

public class Main {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(4);
        stack.push(new Employee(1L, "Jatin", "Arora"));
        stack.push(new Employee(2L, "Kapil", "Arora"));
        stack.push(new Employee(3L, "Mohit", "Arora"));
        stack.push(new Employee(4L, "Nimit", "Arora"));

        System.out.println(stack.size());

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

    }
}
