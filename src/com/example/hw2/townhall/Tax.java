package com.example.hw2.townhall;

public abstract class Tax {

    private float countyTax;
    private float cityTax;
    private boolean isRecurring;

    public Tax(float countyTax, float cityTax, boolean isRecurring) {
        this.countyTax = countyTax;
        this.cityTax = cityTax;
        this.isRecurring = isRecurring;
    }

    public float getCountyTax() {
        return countyTax;
    }

    public void setCountyTax(float countyTax) {
        this.countyTax = countyTax;
    }

    public float getCityTax() {
        return cityTax;
    }

    public void setCityTax(float cityTax) {
        this.cityTax = cityTax;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }
}
