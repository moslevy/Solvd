package com.solvd.townhalldb.jackson.services;


import com.solvd.townhalldb.jackson.impl.buildings.TownHallDAO;
import com.solvd.townhalldb.jackson.impl.persons.EmployeeDAO;
import com.solvd.townhalldb.jackson.models.buildings.TownHall;
import com.solvd.townhalldb.jackson.models.persons.Employee;
import com.solvd.townhalldb.jaxb.abstractClasses.AbstractJdbcDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TownHallService extends AbstractJdbcDao {

    private final static Logger logger = LogManager.getLogger(TownHallService.class);
    private final TownHallDAO townHallDAO = new TownHallDAO();
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public TownHall getTownHallById(long id) {
        TownHall townHall = townHallDAO.getById(id);
        townHall.setCounty("Los Angeles");
        Employee employee = employeeDAO.getById(id);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        townHall.setEmployeeList(employeeList);
        return townHall;
    }

    public void create(TownHall townHall) {
        townHallDAO.create(townHall);
        logger.info("Created TownHall with id " + townHall.getId());
    }

    public void update(TownHall townHall) {
        townHallDAO.update(townHall);
        logger.info("Updated TownHall with id " + townHall.getId());
    }

    public void delete(TownHall townHall) {
        townHallDAO.delete(townHall);
        logger.info("Deleted TownHall with id " + townHall.getId() + " from DB");
    }
}
