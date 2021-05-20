package com.solvd.townhalldb.jackson.models.misc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.jackson.models.persons.Citizen;

public class Telephone extends AbstractEntity {
    @JsonProperty("number")
    private String number;
    @JsonProperty("type")
    private String type;
    @JsonProperty("citizen")
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
