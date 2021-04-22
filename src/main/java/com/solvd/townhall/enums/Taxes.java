package com.solvd.townhall.enums;

public enum Taxes {
    RESIDENTIAL(4, 1.7f), COMMERCIAL(2, 3.6f), INDUSTRIAL (3, 1.2f);

    private float countyTax;
    private float cityTax;



    Taxes(float countyTax, float cityTax) {
        this.countyTax = countyTax;
        this.cityTax = cityTax;
    }

    Taxes(){

    }

    public float getCountyTax() {
        return countyTax;
    }

    public float getCityTax() {
        return cityTax;
    }


}
