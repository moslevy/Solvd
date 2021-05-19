package com.solvd.townhalldb.dao.jdbc.buildings;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.buildings.ITownHallDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TownHallDAO extends AbstractJdbcDao implements ITownHallDAO {

    private static final Logger logger = LogManager.getLogger(TownHallDAO.class);

    private static final String SQL_INSERT = "INSERT INTO TownHall (county) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE TownHall SET county=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM TownHall WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM TownHall WHERE id = ?";

    @Override
    public void create(com.solvd.townhalldb.dao.models.buildings.TownHall townHall) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, townHall.getCounty());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved TownHall: " + townHall.getCounty() + " saved in db");

        } catch (InterruptedException | SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
    }

    @Override
    public void update(com.solvd.townhalldb.dao.models.buildings.TownHall townHall) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, townHall.getCounty());
            rs = ps.executeQuery();
            logger.info("Updated TownHall: " + townHall.getCounty() + " in db");
            rs.next();

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
    }

    @Override
    public com.solvd.townhalldb.dao.models.buildings.TownHall getById(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        com.solvd.townhalldb.dao.models.buildings.TownHall townHall = new com.solvd.townhalldb.dao.models.buildings.TownHall();

        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            townHall.setId(rs.getInt("id"));
            townHall.setCounty(rs.getString("county"));

            logger.info("Got TownHall by id from db");

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
        return townHall;
    }

    @Override
    public void delete(com.solvd.townhalldb.dao.models.buildings.TownHall townHall) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, townHall.getId());
            ps.executeUpdate();

            logger.info("Deleted TownHall " + townHall.getCounty()+ "deleted from db");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeDeleteResources(c, ps);
        }
    }
}
