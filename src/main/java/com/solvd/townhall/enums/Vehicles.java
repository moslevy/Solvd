package com.solvd.townhall.enums;

public enum Vehicles {
    CAR(4, 60), SUV(4, 80), TRUCK(8, 120), HEAVY_CONVENTIONAL(16, 200);

    private int wheels;
    private float gasEmission;

    Vehicles(int wheels, float gasEmission) {
        this.wheels = wheels;
        this.gasEmission = gasEmission;
    }

    public int getWheels() {
        return wheels;
    }

    public float getGasEmission() {
        return gasEmission;
    }
}
