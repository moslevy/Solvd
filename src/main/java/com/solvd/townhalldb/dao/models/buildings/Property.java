package com.solvd.townhalldb.dao.models.buildings;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.dao.models.misc.City;
import com.solvd.townhalldb.dao.models.persons.Citizen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Property extends AbstractEntity {
    @XmlElement(name = "street_number")
    private int street_number;
    @XmlElement(name = "stree_address")
    private String street_address;
    @XmlElement(name = "apartment_number")
    private String apartment_number;
    @XmlElement(name = "owner")
    private String owner;
    @XmlElement(name = "city")
    private City city;
    @XmlElement(name = "citizen")
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
