package com.solvd.townhalldb.dao.jdbc.impl.buildings;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.buildings.IDmvDAO;
import com.solvd.townhalldb.domains.buildings.Dmv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DmvDAO extends AbstractJdbcDao implements IDmvDAO {

    private static final Logger logger = LogManager.getLogger(DmvDAO.class);

    private static final String SQL_INSERT = "INSERT INTO DMVs (town, name, time_open, time_close) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE DMVs SET first_name=?, last_name=?, ssn=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM DMVs WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM DMVs WHERE id = ?";

    @Override
    public void save(Dmv dmv) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, dmv.getTown());
            ps.setString(2, dmv.getName());
            ps.setTime(3, dmv.getTime_open());
            ps.setTime(4, dmv.getTime_close());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved DMV: " + dmv.getName() +" in db");

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
    public void update(Dmv dmv) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, dmv.getTown());
            ps.setString(2, dmv.getName());
            ps.setTime(3, dmv.getTime_open());
            ps.setTime(4, dmv.getTime_close());
            rs = ps.executeQuery();
            logger.info("Updated DMV "+ dmv.getName() +" in db");
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
    public Dmv getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Dmv dmv = new Dmv();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            dmv.setId(rs.getInt(1));
            dmv.setTown(rs.getString("town"));
            dmv.setName(rs.getString("name"));
            dmv.setTime_open(rs.getTime("time_open"));
            dmv.setTime_close(rs.getTime("time_close"));
            logger.info("Got DMV by id from db");

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
        return dmv;
    }

    @Override
    public void delete(Dmv dmv) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, dmv.getId());
            ps.executeUpdate();
            logger.info("Deleted DMV" + dmv.getName() + "from db");


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
