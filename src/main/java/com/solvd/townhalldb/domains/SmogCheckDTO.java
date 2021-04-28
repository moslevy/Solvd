package com.solvd.townhalldb.domains;

import java.util.Date;

public class SmogCheckDTO extends BaseDTO {
    private Date passed_date;
    private Date exp_date;

    public SmogCheckDTO(long id, Date passed_date, Date exp_date) {
        super(id);
        this.passed_date = passed_date;
        this.exp_date = exp_date;
    }

    public SmogCheckDTO() {
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
