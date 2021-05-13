package com.solvd.townhalldb.dao.services;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.jdbc.impl.buildings.PropertyDAO;
import com.solvd.townhalldb.dao.jdbc.impl.persons.CitizenDAO;
import com.solvd.townhalldb.dao.models.buildings.Property;
import com.solvd.townhalldb.dao.models.persons.Citizen;

import java.sql.SQLException;

public class PropertyService extends AbstractJdbcDao {

    public Property getPropertyById(long id) throws SQLException {
        PropertyDAO propertyDAO = new PropertyDAO();
        Property property = propertyDAO.getById(id);
        CitizenDAO citizenDAO = new CitizenDAO();
        Citizen citizen = citizenDAO.getById(property.getCitizen().getId());
        property.setCitizen(citizen);
        return property;
    }


}
