package com.solvd.townhalldb.domains.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

public class SmogCheckOrder extends BaseDTO {

    private Vehicle vehicle;
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
