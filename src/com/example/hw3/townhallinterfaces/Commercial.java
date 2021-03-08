package com.example.hw3.townhallinterfaces;

import java.util.List;

public class Commercial extends Property implements Taxable{

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
    public float calculateTaxes(Property property, Tax tax) {
        float result = 0f;
        CommercialTax commercialTax = (CommercialTax) tax;
        Commercial commercial = (Commercial) property;

        if (commercial.vehicleList.size() > 2) {
            result = commercial.getSquareMeters() * commercialTax.getProductionTax()
                    + commercial.getSquareMeters() * commercialTax.getSewageTax()
                    + commercial.getSquareMeters() * commercialTax.getUnionTax();
        } else {
            result = commercial.getNumOfRetailStores() * commercialTax.getCityTax()
                    + commercial.getSquareMeters() * commercialTax.getCountyTax();
        }
        property.setYearlyTaxes(result);

        printMessage("Implemented interface in Commercial Class");

        return result;
    }

    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }
}