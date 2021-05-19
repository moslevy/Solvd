package com.solvd.townhalldb.dao.jdbc.vehicles;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.vehicles.IVehicleDAO;
import com.solvd.townhalldb.dao.models.buildings.Dmv;
import com.solvd.townhalldb.dao.models.persons.Citizen;
import com.solvd.townhalldb.dao.models.vehicles.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class VehicleDAO extends AbstractJdbcDao implements IVehicleDAO {

    private static final Logger logger = LogManager.getLogger(LicenseDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Vehicles (make, model, year, license_plate, dmvs_id, citizens_id) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Vehicles SET make=?, model=?, year=?, license_plate=?, dmvs_id=?, citizens_id=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Vehicles WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Vehicles WHERE id = ?";

    @Override
    public void create(Vehicle vehicle) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, vehicle.getMake());
            ps.setString(2, vehicle.getModel());
            ps.setInt(3, vehicle.getYear());
            ps.setString(4, vehicle.getLicense_plate());
            ps.setLong(5, vehicle.getDmv().getId());
            ps.setLong(6, vehicle.getCitizen().getId());
            rs = ps.executeQuery();
            logger.info("Saved Vehicle brand: " + vehicle.getMake() + " Model: " + vehicle.getModel() + " in db");
            rs.next();

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);

        }
    }

    @Override
    public void update(Vehicle vehicle) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, vehicle.getMake());
            ps.setString(2, vehicle.getModel());
            ps.setInt(3, vehicle.getYear());
            ps.setString(4, vehicle.getLicense_plate());
            ps.setLong(5, vehicle.getDmv().getId());
            ps.setLong(6, vehicle.getCitizen().getId());
            rs = ps.executeQuery();
            logger.info("Updated Vehicle brand: " + vehicle.getMake() + " Model: " + vehicle.getModel() + " in db");
            rs.next();

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);

        }
    }

    @Override
    public Vehicle getById(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vehicle vehicle = new Vehicle();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            vehicle.setId(rs.getInt(1));
            vehicle.setMake(rs.getString("make"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setYear(rs.getInt("year"));
            vehicle.setLicense_plate(rs.getString("license_plate"));

            Dmv dmv = new Dmv();
            dmv.setId(rs.getLong("dmvs_id"));
            vehicle.setDmv(dmv);

            Citizen citizen = new Citizen();
            citizen.setId(rs.getLong("citizens_id"));
            vehicle.setCitizen(citizen);

            logger.info("Got License by id from db");

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);

        }
        return vehicle;
    }

    @Override
    public void delete(Vehicle vehicle) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, vehicle.getId());
            ps.executeUpdate();
            logger.info("Deleted Vehicle brand: " + vehicle.getMake() + " Model: " + vehicle.getModel() + " in db");


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeDeleteResources(c, ps);
        }
    }
}
