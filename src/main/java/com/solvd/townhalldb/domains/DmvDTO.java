package com.solvd.townhalldb.domains;

import java.util.Date;

public class DmvDTO extends BaseDTO {
    private String town;
    private String name;
    private Date time_open;
    private Date time_close;

    public DmvDTO(long id, String town, String name, Date time_open, Date time_close) {
        super(id);
        this.town = town;
        this.name = name;
        this.time_open = time_open;
        this.time_close = time_close;
    }

    public DmvDTO() {
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

    public Date getTime_open() {
        return time_open;
    }

    public void setTime_open(Date time_open) {
        this.time_open = time_open;
    }

    public Date getTime_close() {
        return time_close;
    }

    public void setTime_close(Date time_close) {
        this.time_close = time_close;
    }
}
