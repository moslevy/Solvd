package com.solvd.townhall.models.people;

import com.solvd.townhall.interfaces.Payable;

import java.util.Date;

public abstract class Person implements Payable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (DOB != null ? !DOB.equals(person.DOB) : person.DOB != null) return false;
        return SSN != null ? SSN.equals(person.SSN) : person.SSN == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (DOB != null ? DOB.hashCode() : 0);
        result = 31 * result + (SSN != null ? SSN.hashCode() : 0);
        return result;
    }
}
