package com.example.hw4.models.properties;

import com.example.hw4.enums.Taxes;
import com.example.hw4.interfaces.IOwnerDetails;
import com.example.hw4.interfaces.ITaxable;
import com.example.hw4.models.people.Person;
import com.example.hw4.models.taxes.CommercialTax;
import com.example.hw4.models.taxes.Tax;
import com.example.hw4.models.vehicles.Vehicle;

import java.util.List;

public class Commercial extends Property implements ITaxable, IOwnerDetails {

    private int numOfRetailStores;
    private boolean isMall;
    private List<Vehicle> vehicleList;

    public Commercial() {
    }

    public Commercial(Address address, Person owner, float squareMeters, int numOfRetailStores, boolean isMall, List<Vehicle> vehicleList) {
        super(address, owner, squareMeters);
        this.numOfRetailStores = numOfRetailStores;
        this.isMall = isMall;
        this.vehicleList = vehicleList;
    }

    public int getNumOfRetailStores() {
        return numOfRetailStores;
    }

    public void setNumOfRetailStores(int numOfRetailStores) {
        this.numOfRetailStores = numOfRetailStores;
    }

    public boolean isMall() {
        return isMall;
    }

    public void setMall(boolean mall) {
        isMall = mall;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public float calculateTaxes(Property property, Taxes tax) {
        float result;
        Taxes commercialTax = tax;
        Commercial commercial = (Commercial) property;

        if (commercial.vehicleList.size() > 2) {
            result = commercial.getSquareMeters() * commercialTax.getProductionTax()
                    + commercial.getSquareMeters() * commercialTax.getSewageTax()
                    + commercial.getSquareMeters() * commercialTax.getUnionTax();
        } else {
            result = commercial.getNumOfRetailStores() * commercialTax.getProductionTax()
                    + commercial.getSquareMeters() * commercialTax.getUnionTax();
        }
        property.setYearlyTaxes(result);

        printMessage("Implemented interface in Commercial Class", "Commercial Property");
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
        System.out.println("Owner's SSN is: " +property.getOwner().getSSN() + " and his "
                + " DOB is: " + property.getOwner().getDOB());
    }
}