package com.solvd.townhalldb.dao.jdbc.misc;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.misc.ICityDAO;
import com.solvd.townhalldb.dao.models.misc.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO extends AbstractJdbcDao implements ICityDAO {

    private static final Logger logger = LogManager.getLogger(CityDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Cities (name) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE Cities SET name=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Cities WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Cities WHERE id = ?";

    @Override
    public void create(City city) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, city.getName());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved City: " + city.getName() +" in db");

        } catch (InterruptedException | SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
    }

    @Override
    public void update(City city) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, city.getName());
            rs = ps.executeQuery();
            logger.info("Updated City "+ city.getName() +" in db");
            rs.next();

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
    }

    @Override
    public City getById(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        City city = new City();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            city.setId(rs.getInt(1));
            city.setName("name");

            logger.info("Got City by id from db");


        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
        return city;
    }

    @Override
    public void delete(City city) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, city.getId());
            ps.executeUpdate();
            logger.info("Deleted City" + city.getName() + "from db");


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeDeleteResources(c, ps);
        }
    }
}
