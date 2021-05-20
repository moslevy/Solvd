package com.solvd.townhalldb.jackson.models.buildings;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.jackson.models.abstractClasses.AbstractEntity;

import java.sql.Time;

public class Dmv extends AbstractEntity {
    @JsonProperty("town")
    private String town;
    @JsonProperty("name")
    private String name;
    @JsonProperty("time_open")
    private Time time_open;
    @JsonProperty("time_close")
    private Time time_close;

    public Dmv(long id, String town, String name, Time time_open, Time time_close) {
        super(id);
        this.town = town;
        this.name = name;
        this.time_open = time_open;
        this.time_close = time_close;
    }

    public Dmv() {
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getTime_open() {
        return time_open;
    }

    public void setTime_open(Time time_open) {
        this.time_open = time_open;
    }

    public Time getTime_close() {
        return time_close;
    }

    public void setTime_close(Time time_close) {
        this.time_close = time_close;
    }
}
