package com.solvd.townhall.models.people;

import com.solvd.townhall.enums.PropertyTypes;
import com.solvd.townhall.enums.Taxes;
import com.solvd.townhall.models.City;
import com.solvd.townhall.models.properties.Address;
import com.solvd.townhall.models.properties.Property;
import com.solvd.townhall.models.taxes.Tax;

import java.util.Date;

public class Citizen extends Person {

    private Address address;
    private Date purchaseDate;

    public Citizen() {
    }

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


    @Override
    public float paymentDue(Property property) {
        float taxesOwed;
        switch (property.getPropertyType()) {

            case SINGLE_FAMILY, MULTI_FAMILY -> {
                taxesOwed = property.calculateTaxes(property, Taxes.RESIDENTIAL);
            }

            case COMMERCIAL, SHOPPING_MALL -> {
                taxesOwed = property.calculateTaxes(property, Taxes.COMMERCIAL);
            }

            case INDUSTRIAL -> {
                taxesOwed =  property.calculateTaxes(property, Taxes.INDUSTRIAL);
            }

            default -> throw new IllegalStateException("Unexpected value: " + property.getPropertyType());
        }
        return taxesOwed;
    }
}
