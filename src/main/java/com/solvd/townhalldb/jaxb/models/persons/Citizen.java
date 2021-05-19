package com.solvd.townhalldb.jaxb.models.persons;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.jaxb.models.vehicles.License;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Citizen extends AbstractEntity {
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

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", license=" + license +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(getFirst_name(), citizen.getFirst_name()) && Objects.equals(getLast_name(), citizen.getLast_name()) && Objects.equals(getSsn(), citizen.getSsn()) && Objects.equals(getLicense(), citizen.getLicense());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getLast_name(), getSsn(), getLicense());
    }
}
