package com.solvd.townhalldb.domains.misc;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

public class State extends BaseDTO {
    private String name;

    public State(long id, String state) {
        super(id);
        this.name = state;
    }
    public State(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
