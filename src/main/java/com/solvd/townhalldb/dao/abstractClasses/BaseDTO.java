package com.solvd.townhalldb.dao.abstractClasses;

public abstract class BaseDTO {
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BaseDTO(long id) {
        this.id = id;
    }

    public BaseDTO(){}
}
