package com.solvd.townhall.models.properties;

import com.solvd.townhall.enums.Taxes;
import com.solvd.townhall.interfaces.IOwnerDetails;
import com.solvd.townhall.interfaces.ITaxable;
import com.solvd.townhall.models.people.Person;

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
    public float calculateTaxes(Property property, Taxes tax) {
        float result;
        Residential residential = (Residential) property;
        Taxes residentialTax = tax;
        if(residential.hasSwimmingPool){
            result = residential.getNumBedrooms()*residentialTax.RESIDENTIAL.getCountyTax()
                    +residential.getSquareMeters()*residentialTax.RESIDENTIAL.getCityTax()
            +residential.getNumBedrooms()*residentialTax.RESIDENTIAL.getCountyTax()*1000;
            residential.setYearlyTaxes(result);
        }else {
            result = residential.getSquareMeters()*residentialTax.RESIDENTIAL.getCityTax()
            +residential.getSquareMeters()*residentialTax.RESIDENTIAL.getCityTax()*1000;
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
