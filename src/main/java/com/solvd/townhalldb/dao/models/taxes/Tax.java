package com.solvd.townhalldb.dao.models.taxes;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

import java.util.Date;

public class Tax extends BaseDTO {
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
}
