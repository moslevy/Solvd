package com.example.hw4.models.properties;

import com.example.hw4.interfaces.IOwnerDetails;
import com.example.hw4.interfaces.ITaxable;
import com.example.hw4.models.people.Person;
import com.example.hw4.models.taxes.ResidentialTax;
import com.example.hw4.models.taxes.Tax;

public class Residential extends Property implements ITaxable, IOwnerDetails {

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
        float result;
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

        printMessage("Implemented interface in Residential Class", "Residential Property");
        purchaseDate(property);
        return result;
    }


    @Override
    public void printMessage(String msg, String typeOfProperty) {
        System.out.println(typeOfProperty);
        System.out.println(msg);
    }

    @Override
    public void purchaseDate(Property property) {
        System.out.println(property.getAddress().toString());
    }
}
