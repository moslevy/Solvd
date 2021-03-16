package com.example.hw2.townhall;

public class ResidentialTax extends Tax{

    private float schoolTax;
    private float freewayTax;

    public ResidentialTax(float countyTax, float cityTax, boolean isRecurring, float schoolTax, float freewayTax) {
        super(countyTax, cityTax, isRecurring);
        this.schoolTax = schoolTax;
        this.freewayTax = freewayTax;
    }

    public float getSchoolTax() {
        return schoolTax;
    }

    public void setSchoolTax(float schoolTax) {
        this.schoolTax = schoolTax;
    }

    public float getFreewayTax() {
        return freewayTax;
    }

    public void setFreewayTax(float freewayTax) {
        this.freewayTax = freewayTax;
    }
}
