package com.solvd.townhalldb.domains;

import java.util.Date;

public class TaxDTO extends BaseDTO{
    private String description;
    private Date exp_date;
    private double amount;

    public TaxDTO(long id, String description, Date exp_date, double amount) {
        super(id);
        this.description = description;
        this.exp_date = exp_date;
        this.amount = amount;
    }

    public TaxDTO(){}

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
}
