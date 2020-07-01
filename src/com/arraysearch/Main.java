package com.arraysearch;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee("Jatin", "Nrora");
        Employee e2 = new Employee("Kapil", "Arora");
        Employee e3 = new Employee("Jatin", "Miglani");

        Employee[] employees = new Employee[3];
        employees[0] = e1;
        employees[1] = e2;
        employees[2] = e3;

        Arrays.sort(employees);

        for(Employee e : employees) {
            System.out.println(e);
        }
    }
}
