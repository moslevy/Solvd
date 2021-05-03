package com.solvd.townhalldb.dao.jdbc.impl.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.vehicles.ISmogCheckOrderDAO;
import com.solvd.townhalldb.domains.vehicles.SmogCheck;
import com.solvd.townhalldb.domains.vehicles.SmogCheckOrder;

import java.sql.SQLException;

public class SmogCheckDAO extends AbstractJdbcDao implements ISmogCheckOrderDAO {

    @Override
    public void save(SmogCheckOrder entity) throws SQLException {

    }

    @Override
    public void update(SmogCheckOrder entity) throws SQLException {

    }

    @Override
    public SmogCheckOrder getById(long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(SmogCheckOrder entity) throws SQLException {

    }
}
