package com.solvd.townhalldb.dao.models.misc;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;
import com.solvd.townhalldb.dao.models.persons.Citizen;

public class Telephone extends BaseDTO {
    private String number;
    private String type;
    private Citizen citizen;

    public Telephone(long id, String number, String type) {
        super(id);
        this.number = number;
        this.type = type;
    }
    public Telephone(){}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
