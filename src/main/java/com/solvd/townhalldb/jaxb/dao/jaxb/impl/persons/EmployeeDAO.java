package com.solvd.townhalldb.jaxb.dao.jaxb.impl.persons;

import com.solvd.townhalldb.jaxb.dao.interfaces.persons.IEmployeeDAO;
import com.solvd.townhalldb.jaxb.models.persons.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.File;

public class EmployeeDAO implements IEmployeeDAO {
    private static final Logger logger = (Logger) LogManager.getLogger(EmployeeDAO.class);
    private static final File FILE = new File("src/main/resources/xmls/jaxb/employees.xml");

    @Override
    public void create(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public Employee getById(long id) {
        return null;
    }

    @Override
    public void delete(Employee employee) {

    }
}
