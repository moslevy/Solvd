package com.solvd.townhalldb.dao.jdbc.impl.buildings;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.buildings.ITypeOfPropertyDAO;
import com.solvd.townhalldb.dao.models.buildings.TypeOfProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeOfPropertyDAO extends AbstractJdbcDao implements ITypeOfPropertyDAO {

    private static final Logger logger = LogManager.getLogger(TypeOfPropertyDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Types_Of_Properties (description) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE Types_Of_Properties SET description=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Types_Of_Properties WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Types_Of_Properties WHERE id = ?";

    @Override
    public void save(TypeOfProperty typeOfProperty) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, typeOfProperty.getDescription());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved type of property: " + typeOfProperty.getDescription() + " saved in db");

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
    public void update(TypeOfProperty typeOfProperty) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, typeOfProperty.getDescription());
            rs = ps.executeQuery();
            logger.info("Updated type of property: " + typeOfProperty.getDescription() + " in db");
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
    public TypeOfProperty getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TypeOfProperty typeOfProperty = new TypeOfProperty();

        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            typeOfProperty.setId(rs.getInt("id"));
            typeOfProperty.setDescription(rs.getString("description"));

            logger.info("Got Type of Property by id from db");

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
        return typeOfProperty;
    }

    @Override
    public void delete(TypeOfProperty typeOfProperty) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, typeOfProperty.getId());
            ps.executeUpdate();

            logger.info("Deleted Type of Property " + typeOfProperty.getDescription() + "deleted from db");

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
