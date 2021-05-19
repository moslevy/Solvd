package com.solvd.townhalldb.jaxb.models.taxes;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

import java.util.Date;
import java.util.Objects;

public class Tax extends AbstractEntity {
    private String description;
    private Date exp_date;
    private double amount;
    private TaxBill taxBill;

    public Tax(long id, String description, Date exp_date, double amount) {
        super(id);
        this.description = description;
        this.exp_date = exp_date;
        this.amount = amount;
    }

    public Tax(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TaxBill getTaxBill() {
        return taxBill;
    }

    public void setTaxBill(TaxBill taxBill) {
        this.taxBill = taxBill;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", exp_date=" + exp_date +
                ", amount=" + amount +
                ", taxBill=" + taxBill +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tax tax = (Tax) o;
        return Double.compare(tax.amount, amount) == 0 && Objects.equals(description, tax.description) && Objects.equals(exp_date, tax.exp_date) && Objects.equals(taxBill, tax.taxBill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, exp_date, amount, taxBill);
    }
}
