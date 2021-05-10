package com.solvd.townhalldb.dao.jdbc.impl.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.vehicles.ISmogCheckDAO;
import com.solvd.townhalldb.jaxb.models.vehicles.SmogCheck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SmogCheckDAO extends AbstractJdbcDao implements ISmogCheckDAO {

    private static final Logger logger = LogManager.getLogger(SmogCheckDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Smog_Checks (passed_date, exp_date) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE Smog_Checks SET passed_date=?, exp_date=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Smog_Checks WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Smog_Checks WHERE id = ?";


    @Override
    public void save(SmogCheck smogCheck) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setDate(1, (Date) smogCheck.getPassed_date());
            ps.setDate(2, (Date) smogCheck.getExp_date());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved Smog Check: " + smogCheck.getId() + " in db");

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
    public void update(SmogCheck smogCheck) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setDate(1, (Date) smogCheck.getPassed_date());
            ps.setDate(2, (Date) smogCheck.getExp_date());
            rs = ps.executeQuery();
            logger.info("Updated Smog Check " + smogCheck.getId() + " in db");
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
    public SmogCheck getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SmogCheck smogCheck = new SmogCheck();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            smogCheck.setId(rs.getInt(1));
            smogCheck.setPassed_date(rs.getDate("passed_date"));
            smogCheck.setExp_date(rs.getDate("exp_date"));

            logger.info("Got Smog Check by id from db");

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
        return smogCheck;
    }

    @Override
    public void delete(SmogCheck smogCheck) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, smogCheck.getId());
            ps.executeUpdate();
            logger.info("Deleted Smog Check" + smogCheck.getId() + "from db");


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
