package com.solvd.townhalldb.dao.jdbc.persons;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.persons.ICitizenDAO;
import com.solvd.townhalldb.dao.models.persons.Citizen;
import com.solvd.townhalldb.dao.models.vehicles.License;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitizenDAO extends AbstractJdbcDao implements ICitizenDAO {

    private static final Logger logger = LogManager.getLogger(CitizenDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Citizens (first_name, last_name, ssn, license) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Citizens SET first_name=?, last_name=?, ssn=?, license=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Citizens WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Citizens WHERE id = ?";


    @Override
    public void create(Citizen citizen) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);

            ps.setString(1, citizen.getFirst_name());
            ps.setString(2, citizen.getLast_name());
            ps.setString(3, citizen.getSsn());
            License license = new License();
            ps.setObject(4, citizen.getLicense());
            rs = ps.executeQuery();
            logger.info("Saved Citizen: " + citizen.getLast_name() +" in db");
            rs.next();


        } catch (InterruptedException | SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
    }

    @Override
    public void update(Citizen citizen)  {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, citizen.getFirst_name());
            ps.setString(2, citizen.getLast_name());
            ps.setString(3, citizen.getSsn());

            rs = ps.executeQuery();
            logger.info("Updated Citizen "+ citizen.getLast_name() +" in db");
            rs.next();

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
    }

    @Override
    public Citizen getById(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Citizen citizen = new Citizen();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            citizen.setId(rs.getInt(1));
            citizen.setFirst_name(rs.getString("first_name"));
            citizen.setLast_name(rs.getString("last_name"));
            citizen.setSsn(rs.getString("ssn"));
            License license= new License();
            license.setId(rs.getLong("licenses_id"));
            citizen.setLicense(license);

            logger.info("Got Citizen by id from db");


        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);
        }
        return citizen;
    }

    @Override
    public void delete(Citizen citizen) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, citizen.getId());
            ps.executeUpdate();
            logger.info("Deleted Citizen" + citizen.getLast_name() + "from db");


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeDeleteResources(c, ps);
        }
    }
}

