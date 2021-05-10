package com.solvd.townhalldb.dao.jdbc.impl.taxes;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.taxes.ITaxBillDAO;
import com.solvd.townhalldb.jaxb.models.buildings.Property;
import com.solvd.townhalldb.jaxb.models.buildings.TownHall;
import com.solvd.townhalldb.jaxb.models.taxes.TaxBill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class TaxBillDAO extends AbstractJdbcDao implements ITaxBillDAO {

    private static final Logger logger = LogManager.getLogger(TaxBillDAO.class);

    private static final String SQL_INSERT = "INSERT INTO TaxBills (townHall_id, property_id) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE TaxBills SET townHall_id=?, property_id=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM TaxBills WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM TaxBills WHERE id = ?";

    @Override
    public void save(TaxBill taxBill) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setObject(1, taxBill.getTownHall());
            ps.setObject(2, taxBill.getProperty());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved TaxBill: " + taxBill.getId() +" in db");

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
    public void update(TaxBill taxBill) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setObject(1, taxBill.getTownHall());
            ps.setObject(2, taxBill.getProperty());
            rs = ps.executeQuery();
            logger.info("Updated TaxBill "+ taxBill.getId() +" in db");
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
    public TaxBill getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        TaxBill taxBill = new TaxBill();

        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();

            taxBill.setId(rs.getLong(1));
            TownHall townHall = new TownHall();
            townHall.setId(rs.getLong("townhall_id"));
            taxBill.setTownHall(townHall);

            Property property = new Property();
            property.setId(rs.getLong("properties_id"));
            taxBill.setProperty(property);

            logger.info("Got Employee by id from db");

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
        return taxBill;
    }

    @Override
    public void delete(TaxBill taxBill) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, taxBill.getId());
            ps.executeUpdate();
            logger.info("Deleted TaxBill" + taxBill.getId() + "from db");


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
