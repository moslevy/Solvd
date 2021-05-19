package com.solvd.townhalldb.dao.models.persons;

import com.solvd.townhalldb.dao.models.abstractClasses.BaseDTO;
import com.solvd.townhalldb.dao.models.adapters.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends BaseDTO {
    @XmlElement(name = "first_name")
    private String first_name;
    @XmlElement(name = "last_name")
    private String last_name;
    @XmlElement(name = "ssn")
    private String ssn;
    @XmlElement(name = "dob")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dob;
    @XmlElement(name = "start_date")
    @XmlJavaTypeAdapter(DateAdapter.class)
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

