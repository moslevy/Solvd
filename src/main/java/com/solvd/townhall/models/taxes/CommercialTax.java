package com.solvd.townhall.models.taxes;

public class CommercialTax extends Tax {

    private float sewageTax;
    private float productionTax;
    private float unionTax;

    public CommercialTax(float countyTax, float cityTax, boolean isRecurring, float sewageTax, float productionTax, float unionTax) {
        super(countyTax, cityTax, isRecurring);
        this.sewageTax = sewageTax;
        this.productionTax = productionTax;
        this.unionTax = unionTax;
    }

    public float getSewageTax() {
        return sewageTax;
    }

    public void setSewageTax(float sewageTax) {
        this.sewageTax = sewageTax;
    }

    public float getProductionTax() {
        return productionTax;
    }

    public void setProductionTax(float productionTax) {
        this.productionTax = productionTax;
    }

    public float getUnionTax() {
        return unionTax;
    }

    public void setUnionTax(float unionTax) {
        this.unionTax = unionTax;
    }
}
