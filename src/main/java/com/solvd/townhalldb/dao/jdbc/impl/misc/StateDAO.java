package com.solvd.townhalldb.dao.jdbc.impl.misc;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.misc.IStateDAO;
import com.solvd.townhalldb.dao.models.misc.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StateDAO extends AbstractJdbcDao implements IStateDAO {

    private static final Logger logger = LogManager.getLogger(StateDAO.class);

    private static final String SQL_INSERT = "INSERT INTO States (name) VALUES(?)";
    private static final String SQL_UPDATE = "UPDATE States SET name=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM States WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM States WHERE id = ?";

    @Override
    public void save(State state) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, state.getName());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved State: " + state.getName() +" in db");

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
    public void update(State state) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, state.getName());
            rs = ps.executeQuery();
            logger.info("Updated State "+ state.getName() +" in db");
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
    public State getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        State state = new State();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            state.setId(rs.getInt(1));
            state.setName("name");

            logger.info("Got State by id from db");


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
        return state;
    }

    @Override
    public void delete(State state) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, state.getId());
            ps.executeUpdate();
            logger.info("Deleted State" + state.getName() + "from db");


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
