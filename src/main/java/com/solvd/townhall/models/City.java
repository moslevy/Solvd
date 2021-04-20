package com.solvd.townhall.models;

import com.solvd.townhall.models.taxes.Tax;
import com.solvd.townhall.models.people.Person;
import com.solvd.townhall.models.properties.Address;
import com.solvd.townhall.models.properties.Property;
import com.solvd.townhall.models.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class City {

    private String name;
    private Address[] addresses;
    private LinkedHashSet<Tax> taxes; // Used HashSet because we can't have repeated items.
    private ArrayList<Person> people;
    private ArrayList<Property> properties;
    private ArrayList<Vehicle> vehicles;

    public City(){}

    public City(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public LinkedHashSet<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(LinkedHashSet<Tax> taxes) {
        this.taxes = taxes;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", addresses=" + Arrays.toString(addresses) +
                ", taxes=" + taxes +
                ", people=" + people +
                ", properties=" + properties +
                ", vehicles=" + vehicles +
                '}';
    }
}
