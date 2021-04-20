package com.solvd.townhall.models.vehicles;

public class Truck extends Vehicle {

    private int wheels;
    private boolean isForkLift;


    public Truck(String brand, String model, String licensePlate, int wheels, boolean isForkLift) {
        super(brand, model, licensePlate);
        this.wheels = wheels;
        this.isForkLift = isForkLift;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public boolean isForkLift() {
        return isForkLift;
    }

    public void setForkLift(boolean forkLift) {
        isForkLift = forkLift;
    }
}
