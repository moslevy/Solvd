package com.solvd.townhalldb.domains;

public class TelephoneDTO extends BaseDTO{
    private String number;
    private String type;

    public TelephoneDTO(long id, String number, String type) {
        super(id);
        this.number = number;
        this.type = type;
    }
    public TelephoneDTO(){}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
