package com.solvd.townhalldb.jackson.models.misc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;


public class City extends AbstractEntity {
    @JsonProperty("name")
    private String name;

    public City(long id, String city) {
        super(id);
        this.name = city;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
