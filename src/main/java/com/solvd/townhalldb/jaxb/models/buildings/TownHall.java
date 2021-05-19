package com.solvd.townhalldb.jaxb.models.buildings;

import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.jaxb.models.persons.Employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class TownHall extends AbstractEntity {
    @XmlElement(name = "county")
    private String county;

    @XmlElement(name = "employee")
    private List<Employee> employeeList = new ArrayList<>();

    public TownHall(){}

    public TownHall(long id, String county) {
        super(id);
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "TownHall{" +
                "id=" + id +
                ", county='" + county + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownHall townHall = (TownHall) o;
        return Objects.equals(county, townHall.county) && Objects.equals(employeeList, townHall.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(county, employeeList);
    }
}
