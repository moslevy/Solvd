package com.solvd.townhalldb.domains.buildings;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

import java.sql.Time;
import java.util.Date;

public class Dmv extends BaseDTO {
    private String town;
    private String name;
    private Time time_open;
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
