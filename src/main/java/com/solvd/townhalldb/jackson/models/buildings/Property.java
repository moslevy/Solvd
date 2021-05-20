package com.solvd.townhalldb.jackson.models.buildings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.jackson.models.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.jackson.models.misc.City;
import com.solvd.townhalldb.jackson.models.persons.Citizen;


public class Property extends AbstractEntity {
    @JsonProperty("street_number")
    private int street_number;
    @JsonProperty("street_address")
    private String street_address;
    @JsonProperty("apartment_number")
    private String apartment_number;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("city")
    private City city;
    @JsonProperty("citizen")
    private Citizen citizen;


    public Property(long id, int street_number, String street_address, String apartment_number, String owner) {
        super(id);
        this.street_number = street_number;
        this.street_address = street_address;
        this.apartment_number = apartment_number;
        this.owner = owner;
    }

    public Property() {
    }

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getApartment_number() {
        return apartment_number;
    }

    public void setApartment_number(String apartment_number) {
        this.apartment_number = apartment_number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
