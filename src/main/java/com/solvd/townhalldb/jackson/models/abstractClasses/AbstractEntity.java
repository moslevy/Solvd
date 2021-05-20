package com.solvd.townhalldb.jackson.models.abstractClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractEntity {
    @JsonProperty("id")
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AbstractEntity(long id) {
        this.id = id;
    }

    public AbstractEntity(){}
}
