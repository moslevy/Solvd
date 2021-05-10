package com.solvd.townhalldb.dao.jdbc.impl.buildings;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.buildings.IPropertyDAO;
import com.solvd.townhalldb.jaxb.models.misc.City;
import com.solvd.townhalldb.jaxb.models.buildings.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PropertyDAO extends AbstractJdbcDao implements IPropertyDAO {

    private static final Logger logger = LogManager.getLogger(PropertyDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Properties (street_number, street_address, apartment_number, owner) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Properties SET street_number=?, street_address=?, apartment_number=?, owner=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Properties WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Properties WHERE id = ?";

    @Override
    public void save(Property property) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setInt(1, property.getStreet_number());
            ps.setString(2, property.getStreet_address());
            ps.setString(3, property.getApartment_number());
            ps.setString(4, property.getOwner());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved Property from owner: " + property.getOwner() + " in db");

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
    public void update(Property property) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setInt(1, property.getStreet_number());
            ps.setString(2, property.getStreet_address());
            ps.setString(3, property.getApartment_number());
            ps.setString(4, property.getOwner());


            rs = ps.executeQuery();
            logger.info("Updated Property from owner:  " + property.getOwner() + " in db");
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
    public Property getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Property property = new Property();

        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            property.setId(rs.getInt("id"));
            property.setStreet_number(rs.getInt("street_number"));
            property.setStreet_address(rs.getString("street_address"));
            property.setApartment_number(rs.getString("apartment_number"));
            property.setOwner(rs.getString("owner"));
            City city = new City();
            city.setId(rs.getLong("cities_id"));
            property.setCity(city);

            logger.info("Got Property by id from db");

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
        return property;
    }

    @Override
    public void delete(Property property) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, property.getId());
            ps.executeUpdate();
            logger.info("Deleted Property located on " + property.getApartment_number() + " " + property.getStreet_number() + " from db");


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
