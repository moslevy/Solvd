package com.solvd.townhalldb.dao.services;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.jdbc.buildings.PropertyDAO;
import com.solvd.townhalldb.dao.jdbc.persons.CitizenDAO;
import com.solvd.townhalldb.dao.models.buildings.Property;
import com.solvd.townhalldb.dao.models.persons.Citizen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyService extends AbstractJdbcDao {

    private final static Logger logger = LogManager.getLogger(TaxService.class);
    private final PropertyDAO propertyDAO = new PropertyDAO();
    private final CitizenDAO citizenDAO = new CitizenDAO();

    public Property getPropertyById(long id) {

        Property property = propertyDAO.getById(id);
        Citizen citizen = citizenDAO.getById(property.getCitizen().getId());
        property.setCitizen(citizen);
        logger.info("Got property by id " + id);
        return property;
    }

    public void create(Property property) {
        propertyDAO.create(property);
        logger.info("Created property with id " + property.getId());
    }

    public void update(Property property) {
        propertyDAO.update(property);
        logger.info("Updated property with id " + property.getId());
    }

    public void delete(Property property) {
        propertyDAO.delete(property);
        logger.info("Deleted property from DB with id " + property.getId());

    }

    public Property getById(long id) {
        Property property = propertyDAO.getById(id);
        logger.info("Got property from DB with id " + id + " and here is the info: " + property.toString());
        return property;


    }


}
