package com.solvd.townhalldb.domains.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

import java.time.Year;

public class Vehicle extends BaseDTO {
    private String make;
    private String model;
    private Year year;
    private String license_plate;

    public Vehicle(long id, String make, String model, Year year, String license_plate) {
        super(id);
        this.make = make;
        this.model = model;
        this.year = year;
        this.license_plate = license_plate;
    }

    public Vehicle() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }
}