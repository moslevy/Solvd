package com.solvd.townhalldb.domains;

public class StateDTO extends BaseDTO{
    private String name;

    public StateDTO(long id, String state) {
        super(id);
        this.name = state;
    }
    public StateDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
