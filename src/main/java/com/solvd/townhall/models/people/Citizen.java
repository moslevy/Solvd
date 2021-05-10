package com.solvd.townhall.models.people;

import com.solvd.townhall.enums.PropertyTypes;
import com.solvd.townhall.enums.Taxes;
import com.solvd.townhall.models.City;
import com.solvd.townhall.models.properties.Address;
import com.solvd.townhall.models.properties.Property;
import com.solvd.townhall.models.taxes.Tax;

import java.util.Date;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Citizen citizen = (Citizen) o;

        if (address != null ? !address.equals(citizen.address) : citizen.address != null) return false;
        return purchaseDate != null ? purchaseDate.equals(citizen.purchaseDate) : citizen.purchaseDate == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
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
