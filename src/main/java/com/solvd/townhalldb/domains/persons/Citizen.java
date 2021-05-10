package com.solvd.townhalldb.domains.persons;

import com.solvd.townhalldb.dao.abstractClasses.BaseDTO;
import com.solvd.townhalldb.domains.vehicles.License;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Citizen extends BaseDTO {
    @XmlElement(name = "first_name")
    private String first_name;
    @XmlElement(name = "last_name")
    private String last_name;
    @XmlElement(name = "ssn")
    private String ssn;
    @XmlElement(name = "license")
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
