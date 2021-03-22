package com.example.hw4.models.people;

import com.example.hw4.models.properties.Address;

import java.util.Date;

public class Citizen extends Person {

    private Address address;
    private Date purchaseDate;

    public Citizen(){}

    public Citizen(String firstName, String lastName, int age, Date DOB, String SSN, Address address, Date purchaseDate) {
        super(firstName, lastName, age, DOB, SSN);
        this.address = address;
        this.purchaseDate = purchaseDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "address=" + address +
                ", purchaseDate=" + purchaseDate +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", SSN='" + SSN + '\'' +
                '}';
    }


}
