package com.solvd.townhalldb.domains;

public class TownHallDTO extends BaseDTO {
    private String county;

    public TownHallDTO(){}

    public TownHallDTO(long id, String county) {
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
