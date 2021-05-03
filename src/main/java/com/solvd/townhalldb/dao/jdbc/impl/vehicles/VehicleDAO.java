package com.solvd.townhalldb.dao.jdbc.impl.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.vehicles.IVehicleDAO;
import com.solvd.townhalldb.domains.vehicles.Vehicle;

import java.sql.SQLException;

public class VehicleDAO extends AbstractJdbcDao implements IVehicleDAO {

    @Override
    public void save(Vehicle entity) throws SQLException {

    }

    @Override
    public void update(Vehicle entity) throws SQLException {

    }

    @Override
    public Vehicle getById(long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Vehicle entity) throws SQLException {

    }
}
