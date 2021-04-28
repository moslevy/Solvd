package com.solvd.townhalldb.domains;

public class TypeOfPropertyDTO extends BaseDTO {
    private String description;

    public TypeOfPropertyDTO(long id, String description) {
        super(id);
        this.description = description;
    }

    public TypeOfPropertyDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
