package com.example.hw4.enums;

public enum Taxes {
    RESIDENTIAL(2, 1.7f), COMMERCIAL(4, 2.3f, 1);

    private float schoolTax;
    private float freewayTax;

    private float sewageTax;
    private float productionTax;
    private float unionTax;

    Taxes(float i, float v) {
        this.schoolTax = i;
        this.freewayTax = v;
    }

    Taxes(float i, float v, float z){
        this.sewageTax = i;
        this.productionTax = v;
        this.unionTax = z;
    }
    Taxes(){

    }

    public float getSchoolTax() {
        return schoolTax;
    }

    public float getFreewayTax() {
        return freewayTax;
    }

    public float getSewageTax() {
        return sewageTax;
    }

    public float getProductionTax() {
        return productionTax;
    }

    public float getUnionTax() {
        return unionTax;
    }
}
