package com.solvd.townhalldb.jackson.models.vehicles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

public class SmogCheckOrder extends AbstractEntity {

    @JsonProperty("vehicle")
    private Vehicle vehicle;
    @JsonProperty("smogcheck")
    private SmogCheck smogCheck;

    public SmogCheckOrder(long id) {
        super(id);
    }

    public SmogCheckOrder() {

    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public SmogCheck getSmogCheck() {
        return smogCheck;
    }

    public void setSmogCheck(SmogCheck smogCheck) {
        this.smogCheck = smogCheck;
    }
}
