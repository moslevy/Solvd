package com.solvd.townhalldb.domains.persons;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;
import com.solvd.townhalldb.domains.vehicles.License;

public class Citizen extends BaseDTO {
    private String first_name;
    private String last_name;
    private String ssn;
    private License license;

    public Citizen(long id, String name, String last_name, String ssn) {
        super(id);
        this.first_name = name;
        this.last_name = last_name;
        this.ssn = ssn;
    }

    public Citizen() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}
