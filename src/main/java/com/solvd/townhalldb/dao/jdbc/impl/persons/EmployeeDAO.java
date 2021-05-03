package com.solvd.townhalldb.dao.jdbc.impl.persons;

import com.solvd.townhalldb.dao.abstractClasses.AbstractJdbcDao;
import com.solvd.townhalldb.dao.interfaces.persons.IEmployeeDAO;
import com.solvd.townhalldb.domains.persons.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class EmployeeDAO extends AbstractJdbcDao implements IEmployeeDAO {

    private static final Logger logger = LogManager.getLogger(EmployeeDAO.class);

    private static final String SQL_INSERT = "INSERT INTO Employees (first_name, last_name, ssn, dob, start_date) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Employees SET first_name=?, last_name=?, ssn=?, dob=?, start_date=? WHERE id = ?";
    private final static String SQL_GET_BY_ID = "SELECT * FROM Employees WHERE id = ?";
    private final static String SQL_DELETE = "DELETE FROM Employees WHERE id = ?";

    @Override
    public void save(Employee employee) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_INSERT);
            ps.setString(1, employee.getFirst_name());
            ps.setString(2, employee.getLast_name());
            ps.setString(3, employee.getSsn());
            ps.setDate(4, (Date) employee.getDob());
            ps.setDate(5, (Date) employee.getStart_date());
            rs = ps.executeQuery();
            rs.next();
            logger.info("Saved Employee: " + employee.getLast_name() +" in db");

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
    public void update(Employee employee) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_UPDATE);
            ps.setString(1, employee.getFirst_name());
            ps.setString(2, employee.getLast_name());
            ps.setString(3, employee.getSsn());
            ps.setDate(4, (Date) employee.getDob());
            ps.setDate(5, (Date) employee.getStart_date());
            rs = ps.executeQuery();
            logger.info("Updated Employee "+ employee.getLast_name() +" in db");
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
    public Employee getById(long id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee employee = new Employee();
        try {
            c = (Connection) getCp().getConnection();
            ps = c.prepareStatement(SQL_GET_BY_ID);
            rs = ps.executeQuery();
            rs.next();
            employee.setId(rs.getInt(1));
            employee.setFirst_name(rs.getString("first_name"));
            employee.setLast_name(rs.getString("last_name"));
            employee.setSsn(rs.getString("ssn"));
            employee.setDob(rs.getDate("dob"));
            employee.setStart_date(rs.getDate("start_date"));

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
        return employee;
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            ps = c.prepareStatement(SQL_DELETE);
            ps.setLong(1, employee.getId());
            ps.executeUpdate();
            logger.info("Deleted Employee" + employee.getLast_name() + "from db");


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
