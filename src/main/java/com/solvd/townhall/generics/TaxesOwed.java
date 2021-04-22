package com.solvd.townhall.generics;

import com.solvd.townhall.models.people.Person;

public class TaxesOwed <P extends Person>{
    private P propertyOwner;
    private float taxesOwed;

    public TaxesOwed(P propertyOwner, float taxesOwed ){
        this.propertyOwner = propertyOwner;
        this.taxesOwed = taxesOwed;
    }

    public P getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(P propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public float getTaxesOwed() {
        return taxesOwed;
    }

    public void setTaxesOwed(float taxesOwed) {
        this.taxesOwed = taxesOwed;
    }

    @Override
    public String toString() {
        return "TaxesOwed{" +
                "propertyOwner=" + propertyOwner +
                ", taxesOwed=" + taxesOwed +
                '}';
    }
}
