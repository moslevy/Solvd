package com.solvd.townhalldb.jaxb.wrappers.buildings;


import com.solvd.townhalldb.jaxb.models.persons.Employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "townhall")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownHall {
    private final File FILE = new File("src/main/resources/xmls/jaxb/townhall.xml");

    @XmlElement(name = "county")
    private String county;

    private List<Employee> employeesList = new ArrayList<>();

    public File getFILE() {
        return FILE;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }
}
