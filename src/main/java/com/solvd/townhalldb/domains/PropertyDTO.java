package com.solvd.townhalldb.domains;

public class PropertyDTO extends BaseDTO{
    private int street_number;
    private String street_address;
    private String apartment_number;
    private String owner;

    public PropertyDTO(long id, int street_number, String street_address, String apartment_number, String owner) {
        super(id);
        this.street_number = street_number;
        this.street_address = street_address;
        this.apartment_number = apartment_number;
        this.owner = owner;
    }

    public PropertyDTO(){}

    public int getStreet_number() {
        return street_number;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getApartment_number() {
        return apartment_number;
    }

    public void setApartment_number(String apartment_number) {
        this.apartment_number = apartment_number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
