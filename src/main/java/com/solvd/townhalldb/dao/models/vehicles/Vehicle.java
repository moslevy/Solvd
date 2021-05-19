package com.solvd.townhalldb.dao.models.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.dao.models.buildings.Dmv;
import com.solvd.townhalldb.dao.models.persons.Citizen;

import java.util.Objects;

public class Vehicle extends AbstractEntity {
    private String make;
    private String model;
    private int year;
    private String license_plate;
    private Dmv dmv;
    private Citizen citizen;

    public Vehicle(long id, String make, String model, int year, String license_plate) {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public Dmv getDmv() {
        return dmv;
    }

    public void setDmv(Dmv dmv) {
        this.dmv = dmv;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", license_plate='" + license_plate + '\'' +
                ", dmv=" + dmv +
                ", citizen=" + citizen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getYear() == vehicle.getYear() && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getLicense_plate(), vehicle.getLicense_plate()) && Objects.equals(getDmv(), vehicle.getDmv()) && Objects.equals(getCitizen(), vehicle.getCitizen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMake(), getModel(), getYear(), getLicense_plate(), getDmv(), getCitizen());
    }
}
