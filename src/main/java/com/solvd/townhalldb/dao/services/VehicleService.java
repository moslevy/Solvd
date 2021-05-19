package com.solvd.townhalldb.dao.services;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.jdbc.buildings.DmvDAO;
import com.solvd.townhalldb.dao.jdbc.persons.CitizenDAO;
import com.solvd.townhalldb.dao.jdbc.vehicles.VehicleDAO;
import com.solvd.townhalldb.dao.models.buildings.Dmv;
import com.solvd.townhalldb.dao.models.persons.Citizen;
import com.solvd.townhalldb.dao.models.vehicles.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VehicleService extends AbstractJdbcDao {
    private final static Logger logger = LogManager.getLogger(VehicleService.class);
    private final VehicleDAO vehicleDAO = new VehicleDAO();
    private final DmvDAO dmvDAO = new DmvDAO();
    private final CitizenDAO citizenDAO = new CitizenDAO();

    public Vehicle getVehicleById(long id) {
        Vehicle vehicle = vehicleDAO.getById(id);
        Dmv dmv = dmvDAO.getById(vehicle.getDmv().getId());
        Citizen citizen = citizenDAO.getById(vehicle.getCitizen().getId());
        vehicle.setDmv(dmv);
        vehicle.setCitizen(citizen);
        return vehicle;
    }

    public void create(Vehicle vehicle) {
        vehicleDAO.create(vehicle);
        logger.info("Created vehicle with id" + vehicle.getId());
    }

    public void update(Vehicle vehicle) {
        vehicleDAO.update(vehicle);
        logger.info("Updated vehicle with id " + vehicle.getId());
    }

    public void delete(Vehicle vehicle) {
        vehicleDAO.delete(vehicle);
        logger.info("Deleted vehicle with id " + vehicle.getId());
    }
}


