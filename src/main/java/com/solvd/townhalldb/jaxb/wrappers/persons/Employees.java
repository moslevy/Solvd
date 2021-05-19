package com.solvd.townhalldb.jaxb.wrappers.persons;


import com.solvd.townhalldb.jaxb.models.persons.Employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {
    private final File FILE = new File("src/main/resources/xmls/jaxb/employees.xml");

    @XmlElement (name = "employee")
    private List<Employee> employeeList = null;

    public File getFILE() {
        return FILE;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
