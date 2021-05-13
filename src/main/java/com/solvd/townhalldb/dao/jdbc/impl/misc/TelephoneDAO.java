package com.solvd.townhalldb.dao.jdbc.impl.misc;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.misc.ITelephoneDAO;
import com.solvd.townhalldb.dao.models.misc.Telephone;
import com.solvd.townhalldb.dao.models.persons.Citizen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelephoneDAO extends AbstractJdbcDao implements ITelephoneDAO {
    private static final Logger logger = LogManager.getLogger(TelephoneDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Telephones (number, type, citizen) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Telephones SET number=?, type=?, citizen=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Telephones WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Telephones WHERE id = ?";

    @Override
    public void save(Telephone telephone) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, telephone.getNumber());
            ps.setString(2, telephone.getType());
            Citizen citizen = new Citizen();
            citizen.setId(rs.getLong("citizens_id"));
            telephone.setCitizen(citizen);

            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved Telephone: " + telephone.getNumber() + " in db");

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
    public void update(Telephone telephone) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, telephone.getNumber());
            ps.setString(2, telephone.getType());
            Citizen citizen = new Citizen();
            citizen.setId(rs.getLong("citizens_id"));
            telephone.setCitizen(citizen);

            rs = ps.executeQuery();
            logger.info("Updated Telephone " + telephone.getNumber() + " in db");
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
    public Telephone getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Telephone telephone = new Telephone();

        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            telephone.setId(rs.getInt("id"));
            telephone.setNumber(rs.getString("number"));
            telephone.setType(rs.getString("type"));
            Citizen citizen = new Citizen();
            citizen.setId(rs.getInt("citizens_id"));
            telephone.setCitizen(citizen);

            logger.info("Got Telephone by id from db");


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
        return telephone;
    }

    @Override
    public void delete(Telephone telephone) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, telephone.getId());
            ps.executeUpdate();
            logger.info("Deleted Telephone #" + telephone.getNumber() + "from db");


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
