package com.solvd.townhalldb.jackson.models.buildings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

public class TypeOfProperty extends AbstractEntity {
    @JsonProperty("description")
    private String description;

    public TypeOfProperty(long id, String description) {
        super(id);
        this.description = description;
    }

    public TypeOfProperty() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
