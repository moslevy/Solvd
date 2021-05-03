package com.solvd.townhalldb.domains.buildings;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

public class TownHall extends BaseDTO {
    private String county;

    public TownHall(){}

    public TownHall(long id, String county) {
        super(id);
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}