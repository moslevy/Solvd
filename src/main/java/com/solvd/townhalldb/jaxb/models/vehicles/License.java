package com.solvd.townhalldb.jaxb.models.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

import java.util.Date;

public class License extends AbstractEntity {
    private int number;
    private Date exp_date;

    public License(long id, int number, Date exp_date) {
        super(id);
        this.number = number;
        this.exp_date = exp_date;
    }

    public License() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }
}
