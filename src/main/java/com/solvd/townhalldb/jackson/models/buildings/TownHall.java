package com.solvd.townhalldb.jackson.models.buildings;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.townhalldb.dao.abstractClasses.AbstractEntity;
import com.solvd.townhalldb.jackson.models.persons.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TownHall extends AbstractEntity {
    @JsonProperty("county")
    private String county;

    @JsonProperty("employee")
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
