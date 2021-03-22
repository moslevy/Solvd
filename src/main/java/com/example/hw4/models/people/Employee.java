package com.example.hw4.models.people;

import java.util.Date;

public class Employee extends Person {

    private int employeeId;
    private String position;

    public Employee(){

    }


    public Employee(int employeeId, String position) {
        this.employeeId = employeeId;
        this.position = position;
    }

    public Employee(String firstName, String lastName, int age, Date DOB, String SSN, int employeeId, String position) {
        super(firstName, lastName, age, DOB, SSN);
        this.employeeId = employeeId;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", position='" + position + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}
