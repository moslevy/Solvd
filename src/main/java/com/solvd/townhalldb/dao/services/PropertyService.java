package com.solvd.townhalldb.dao.services;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.jdbc.impl.misc.CityDAO;
import com.solvd.townhalldb.dao.jdbc.impl.buildings.PropertyDAO;
import com.solvd.townhalldb.domains.misc.City;
import com.solvd.townhalldb.domains.buildings.Property;

import java.sql.SQLException;

public class PropertyService extends AbstractJdbcDao {

    public Property getPropertyById(long id) throws SQLException {
        PropertyDAO propertyDAO = new PropertyDAO();
        Property property = propertyDAO.getById(id);
        CityDAO cityDAO = new CityDAO();
        City city = cityDAO.getById(property.getCity().getId());
        property.setCity(city);

        return property;
    }
}
