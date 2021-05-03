package com.solvd.townhalldb.domains.misc;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

public class City extends BaseDTO {
    private String name;

    public City(long id, String city) {
        super(id);
        this.name = city;
    }
    public City(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
