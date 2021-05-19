package com.solvd.townhalldb.dao.models.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

import java.util.Date;

public class SmogCheck extends AbstractEntity {
    private Date passed_date;
    private Date exp_date;

    public SmogCheck(long id, Date passed_date, Date exp_date) {
        super(id);
        this.passed_date = passed_date;
        this.exp_date = exp_date;
    }

    public SmogCheck() {
    }

    public Date getPassed_date() {
        return passed_date;
    }

    public void setPassed_date(Date passed_date) {
        this.passed_date = passed_date;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }
}
