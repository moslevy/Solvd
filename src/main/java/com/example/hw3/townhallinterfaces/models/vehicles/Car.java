package com.example.hw3.townhallinterfaces.models.vehicles;

public class Car extends Vehicle {

    private float engineSize;
    private String color;
    private boolean isElectric;

    public Car(String brand, String model, String licensePlate, float engineSize, String color, boolean isElectric) {
        super(brand, model, licensePlate);
        this.engineSize = engineSize;
        this.color = color;
        this.isElectric = isElectric;
    }

    public float getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(float engineSize) {
        this.engineSize = engineSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineSize=" + engineSize +
                ", color='" + color + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }
}
