package com.solvd.townhall.models.people;

import java.util.Date;

public abstract class Person {

    String firstName;
    String lastName;
    int age;
    Date DOB;
    String SSN;

    public Person() {

    }

    public Person(String firstName, String lastName, int age, Date DOB, String SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.DOB = DOB;
        this.SSN = SSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", DOB=" + DOB +
                ", SSN='" + SSN + '\'' +
                '}';
    }
}
