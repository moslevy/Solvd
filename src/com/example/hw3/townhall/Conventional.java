package com.example.hw3.townhall;

public class Conventional extends Vehicle {

    private int numAxles;

    public Conventional(String brand, String model, String licensePlate, int numAxels) {
        super(brand, model, licensePlate);
        this.numAxles = numAxels;
    }

    public int getNumAxles() {
        return numAxles;
    }

    public void setNumAxles(int numAxles) {
        this.numAxles = numAxles;
    }

}
