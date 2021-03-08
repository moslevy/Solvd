package com.example.hw3.townhallinterfaces;

public class Residential extends Property implements Taxable, OwnerDetails {

    private int numBedrooms;
    private boolean hasSwimmingPool;

    public Residential() {
    }

    public Residential(Address address, Person owner, float squareMeters, int numBedrooms, boolean hasSwimmingPool) {
        super(address, owner, squareMeters);
        this.numBedrooms = numBedrooms;
        this.hasSwimmingPool = hasSwimmingPool;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public void setNumBedrooms(int numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public boolean isHasSwimmingPool() {
        return hasSwimmingPool;
    }

    public void setHasSwimmingPool(boolean hasSwimmingPool) {
        this.hasSwimmingPool = hasSwimmingPool;
    }

    @Override
    public String toString() {
        return "Residential{" +
                "numBedrooms=" + numBedrooms +
                ", hasSwimmingPool=" + hasSwimmingPool +
                '}';
    }

    @Override
    public float calculateTaxes(Property property, Tax tax) {
        float result= 0f;
        Residential residential = (Residential) property;
        ResidentialTax residentialTax = (ResidentialTax) tax;
        if(residential.hasSwimmingPool){
            result = residential.getNumBedrooms()*residentialTax.getCountyTax()
                    +residential.getSquareMeters()*residentialTax.getFreewayTax()
            +residential.getNumBedrooms()*residentialTax.getSchoolTax()*1000;
            residential.setYearlyTaxes(result);
        }else {
            result = residential.getSquareMeters()*tax.getCityTax()
            +residential.getSquareMeters()*residentialTax.getFreewayTax()*1000;
            residential.setYearlyTaxes(result);
        }

        printMessage("Implemented interface in Residential Class", "Orange");
        purchaseDate(property);
        return result;
    }


    @Override
    public void printMessage(String msg, String color) {
        System.out.println(color);
        System.out.println(msg);
    }

    @Override
    public void purchaseDate(Property property) {
        System.out.println(property.getAddress().toString());
    }
}
