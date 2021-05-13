package com.solvd.townhalldb.dao.models.buildings;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;

public class TypeOfProperty extends BaseDTO {
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
