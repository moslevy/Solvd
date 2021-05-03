package com.solvd.townhalldb.dao.jdbc.impl.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.vehicles.ISmogCheckOrderDAO;
import com.solvd.townhalldb.domains.vehicles.License;
import com.solvd.townhalldb.domains.vehicles.SmogCheck;
import com.solvd.townhalldb.domains.vehicles.SmogCheckOrder;
import com.solvd.townhalldb.domains.vehicles.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SmogCheckOrderDAO extends AbstractJdbcDao implements ISmogCheckOrderDAO {
    private static final Logger logger = LogManager.getLogger(SmogCheckOrderDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Smog_Checks_Orders (vehicles_id, smog_checks_id) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Smog_Checks_Orders SET vehicles_id=?, smog_checks_id=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Smog_Checks_Orders WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Smog_Checks_Orders WHERE id = ?";

    @Override
    public void save(SmogCheckOrder smogCheckOrder) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            Vehicle vehicle = new Vehicle();
            vehicle.setId(rs.getLong("id"));
            ps.setObject(1, vehicle);
            SmogCheck smogCheck = new SmogCheck();
            smogCheck.setId(rs.getLong("id"));
            ps.setObject(1, smogCheck);
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved Smog Check Order: " + smogCheck.getId() + " in db");

        } catch (InterruptedException | SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }

    @Override
    public void update(SmogCheckOrder smogCheckOrder) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setObject(1, smogCheckOrder.getVehicle());
            ps.setObject(2, smogCheckOrder.getSmogCheck());
            rs = ps.executeQuery();
            logger.info("Updated Smog Check Order " + smogCheckOrder.getId() + " in db");
            rs.next();

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }

    @Override
    public SmogCheckOrder getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SmogCheckOrder smogCheckOrder = new SmogCheckOrder();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            smogCheckOrder.setId(rs.getInt(1));
            Vehicle vehicle = new Vehicle();
            smogCheckOrder.setVehicle(vehicle);
            SmogCheck smogCheck = new SmogCheck();
            smogCheckOrder.setSmogCheck(smogCheck);

            logger.info("Got Smog Check Order by id from db");

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
        return smogCheckOrder;
    }

    @Override
    public void delete(SmogCheckOrder smogCheckOrder) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, smogCheckOrder.getId());
            ps.executeUpdate();
            logger.info("Deleted Smog Check Order" + smogCheckOrder.getId() + "from db");


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }
}
