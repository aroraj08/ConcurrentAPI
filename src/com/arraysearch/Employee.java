package com.arraysearch;

public class Employee implements Comparable<Employee>{

    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {

        int returnVal = this.firstName.compareTo(employee.firstName);
        if (returnVal == 0) {
            returnVal =  this.lastName.compareTo(employee.lastName);
        }
        return returnVal;
    }
}
