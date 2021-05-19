package com.solvd.townhalldb.dao.jdbc.taxes;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.taxes.ITaxDAO;
import com.solvd.townhalldb.dao.models.taxes.Tax;
import com.solvd.townhalldb.dao.models.taxes.TaxBill;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class TaxDAO extends AbstractJdbcDao implements ITaxDAO {

    private static final Logger logger = LogManager.getLogger(TaxDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Taxes (description, exp_date, amount, tax_bills_id) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Taxes SET description=?, exp_date=?, amount=?, tax_bills_id=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Taxes WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Taxes WHERE id = ?";

    @Override
    public void create(Tax tax) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, tax.getDescription());
            ps.setDate(2, (Date) tax.getExp_date());
            ps.setDouble(3, tax.getAmount());
            TaxBill taxBill = new TaxBill();
            taxBill.setId(rs.getLong("tax_bills_id"));
            ps.setObject(4, taxBill);

            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved Tax: " + tax.getDescription() + " in db");

        } catch (InterruptedException | SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeResources(c, ps, rs);

        }
    }

    @Override
    public void update(Tax tax) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, tax.getDescription());
            ps.setDouble(2, tax.getAmount());
            ps.setDate(3, (Date) tax.getExp_date());
            ps.setObject(4, tax.getTaxBill());

            rs = ps.executeQuery();
            logger.info("Updated Tax " + tax.getId() + " in db");
            rs.next();

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);

        }
    }

    @Override
    public Tax getById(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Tax tax = new Tax();

        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();


            tax.setId(rs.getLong(1));
            TaxBill taxBill = new TaxBill();
            taxBill.setId(rs.getLong("tax_bills_id"));
            tax.setTaxBill(taxBill);

            logger.info("Got Tax by id from db");

        } catch (InterruptedException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(c, ps, rs);

        }
        return tax;
    }

    @Override
    public void delete(Tax tax) {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, tax.getId());
            ps.executeUpdate();
            logger.info("Deleted Tax" + tax.getId() + " from db");


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            closeDeleteResources(c, ps);
        }
    }
}
