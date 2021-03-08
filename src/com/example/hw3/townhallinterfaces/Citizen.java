package com.example.hw3.townhallinterfaces;

import java.util.Date;

public class Citizen extends Person{

    private Address address;
    private Date purchaseDate;

    public Citizen(){}

    public Citizen(String firstName, String lastName, Date DOB, String SSN, Address address, Date purchaseDate) {
        super(firstName, lastName, DOB, SSN);
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
