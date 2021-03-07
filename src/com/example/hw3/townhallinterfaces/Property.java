package com.example.hw3.townhallinterfaces;

public abstract class Property {

    private Address address;
    private Person owner;
    private float squareMeters;
    private float yearlyTaxes;

    public Property() {
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

    @Override
    public String toString() {
        return "Property{" +
                ", address=" + address +
                ", squareMeters=" + squareMeters +
                ", yearlyTaxes=" + yearlyTaxes +
                '}';
    }

    public abstract float calculateTaxes(Property property, Tax tax);

}
