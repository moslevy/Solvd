package com.solvd.townhalldb.dao.jdbc.impl.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.vehicles.ILicenseDAO;
import com.solvd.townhalldb.jaxb.models.vehicles.License;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class LicenseDAO extends AbstractJdbcDao implements ILicenseDAO {

    private static final Logger logger = LogManager.getLogger(LicenseDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Licenses (number, exp_date) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Licenses SET number=?, exp_date=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Licenses WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Licenses WHERE id = ?";

    @Override
    public void save(License license) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setInt(1, license.getNumber());
            ps.setDate(2, (Date) license.getExp_date());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved License: " + license.getNumber() + " in db");

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
    public void update(License license) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setInt(1, license.getNumber());
            ps.setDate(2, (Date) license.getExp_date());
            rs = ps.executeQuery();
            logger.info("Updated License " + license.getNumber() + " in db");
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
    public License getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        License license = new License();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            license.setId(rs.getInt(1));
            license.setNumber(rs.getInt("number"));
            license.setExp_date(rs.getDate("exp_date"));

            logger.info("Got License by id from db");

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
        return license;
    }

    @Override
    public void delete(License license) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, license.getId());
            ps.executeUpdate();
            logger.info("Deleted License" + license.getNumber() + "from db");


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
