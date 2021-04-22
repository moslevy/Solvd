package com.solvd.townhall.models.properties;

import com.solvd.townhall.enums.PropertyTypes;
import com.solvd.townhall.enums.Taxes;
import com.solvd.townhall.models.people.Person;

public abstract class Property {

    private Address address;
    private Person owner;
    private float squareMeters;
    private float yearlyTaxes;
    private PropertyTypes propertyType;

    public Property() {
    }

    public Property(Address address, Person owner, float squareMeters, PropertyTypes propertyType) {
        this.address = address;
        this.owner = owner;
        this.squareMeters = squareMeters;
        this.propertyType =propertyType;
    }

    public Property(Address address, Person owner, float squareMeters) {
        this.address = address;
        this.owner = owner;
        this.squareMeters = squareMeters;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public float getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(float squareMeters) {
        this.squareMeters = squareMeters;
    }

    public float getYearlyTaxes() {
        return yearlyTaxes;
    }

    public void setYearlyTaxes(float yearlyTaxes) {
        this.yearlyTaxes = yearlyTaxes;
    }

    public PropertyTypes getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyTypes propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "Property{" +
                "address=" + address +
                ", owner=" + owner +
                ", squareMeters=" + squareMeters +
                ", yearlyTaxes=" + yearlyTaxes +
                ", propertyTypes=" + propertyType +
                '}';
    }

    public abstract float calculateTaxes(Property property, Taxes tax);

}
