package com.solvd.townhalldb.domains;

import java.util.Date;

public class LicenseDTO extends BaseDTO {
    private int number;
    private Date exp_date;

    public LicenseDTO(long id, int number, Date exp_date) {
        super(id);
        this.number = number;
        this.exp_date = exp_date;
    }

    public LicenseDTO() {
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
