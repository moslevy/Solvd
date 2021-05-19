package com.solvd.townhalldb.dao.models.buildings;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;

public class TypeOfProperty extends AbstractEntity {
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
