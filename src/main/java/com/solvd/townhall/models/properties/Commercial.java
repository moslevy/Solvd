package com.solvd.townhall.models.properties;

import com.solvd.townhall.enums.PropertyTypes;
import com.solvd.townhall.enums.Taxes;
import com.solvd.townhall.interfaces.IOwnerDetails;
import com.solvd.townhall.interfaces.ITaxable;
import com.solvd.townhall.models.people.Person;
import com.solvd.townhall.models.vehicles.Vehicle;

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
            result = commercial.getSquareMeters() * commercialTax.getCityTax()
                    + commercial.getSquareMeters() * commercialTax.getCountyTax();
        } else {
            result = commercial.getNumOfRetailStores() * commercialTax.getCountyTax()
                    + commercial.getSquareMeters() * commercialTax.getCityTax();
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
        System.out.println("Owner's SSN is: " + property.getOwner().getSSN() + " and his "
                + " DOB is: " + property.getOwner().getDOB());
    }
}