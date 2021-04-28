package com.solvd.townhalldb.domains;

public class CityDTO extends BaseDTO{
    private String name;

    public CityDTO(long id, String city) {
        super(id);
        this.name = city;
    }
    public CityDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
