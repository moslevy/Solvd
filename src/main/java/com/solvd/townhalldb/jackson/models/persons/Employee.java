package com.solvd.townhalldb.jackson.models.persons;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.jackson.models.abstractClasses.AbstractEntity;

import java.util.Date;
import java.util.Objects;

public class Employee extends AbstractEntity {
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("ssn")
    private String ssn;
    @JsonProperty("dob")
    private Date dob;
    @JsonProperty("start_date")
    private Date start_date;

    public Employee(long id, String first_name, String last_name, String ssn, Date dob, Date start_date) {
        super(id);
        this.first_name = first_name;
        this.last_name = last_name;
        this.ssn = ssn;
        this.dob = dob;
        this.start_date = start_date;
    }

    public Employee() {

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", dob=" + dob +
                ", start_date=" + start_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(ssn, employee.ssn) && Objects.equals(dob, employee.dob) && Objects.equals(start_date, employee.start_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, ssn, dob, start_date);
    }
}

