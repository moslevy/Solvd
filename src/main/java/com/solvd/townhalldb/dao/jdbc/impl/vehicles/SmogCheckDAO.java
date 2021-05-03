package com.solvd.townhalldb.dao.jdbc.impl.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.vehicles.ISmogCheckDAO;
import com.solvd.townhalldb.dao.interfaces.vehicles.ISmogCheckOrderDAO;
import com.solvd.townhalldb.domains.vehicles.SmogCheck;
import com.solvd.townhalldb.domains.vehicles.SmogCheckOrder;

import java.sql.SQLException;

public class SmogCheckDAO extends AbstractJdbcDao implements ISmogCheckDAO {


    @Override
    public void save(SmogCheck entity) throws SQLException {

    }

    @Override
    public void update(SmogCheck entity) throws SQLException {

    }

    @Override
    public SmogCheck getById(long id) throws SQLException {
        return null;
    }

    @Override
    public void delete(SmogCheck entity) throws SQLException {

    }
}
