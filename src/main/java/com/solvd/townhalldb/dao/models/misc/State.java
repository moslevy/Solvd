package com.solvd.townhalldb.dao.models.misc;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

public class State extends AbstractEntity {
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
