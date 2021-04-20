package com.solvd.townhall.generics;

public class Report<O, P, T> {
    private O owner;
    private P property;
    private T taxes;

    public Report() {

    }

    public Report (O owner, P property, T taxes){
        this.owner = owner;
        this.property = property;
        this.taxes = taxes;
    }

    public O getOwner() {
        return owner;
    }

    public void setOwner(O owner) {
        this.owner = owner;
    }

    public P getProperty() {
        return property;
    }

    public void setProperty(P property) {
        this.property = property;
    }

    public T getTaxes() {
        return taxes;
    }

    public void setTaxes(T taxes) {
        this.taxes = taxes;
    }

    @Override
    public String toString() {
        return "Report{" +
                "owner=" + owner +
                ", property=" + property +
                ", taxes=" + taxes +
                '}';
    }
}