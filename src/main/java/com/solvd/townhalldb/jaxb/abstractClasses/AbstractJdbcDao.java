package com.solvd.townhalldb.jaxb.abstractClasses;


import com.solvd.townhalldb.connectionPool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractJdbcDao {
    private static final Logger logger = (Logger) LogManager.getLogger(AbstractJdbcDao.class);

    private ConnectionPool cp = ConnectionPool.getInstance();

    public ConnectionPool getCp() {
        return cp;
    }

    public void setCp(ConnectionPool cp) {
        this.cp = cp;
    }

    public AbstractJdbcDao(){}

    public AbstractJdbcDao(ConnectionPool cp) {
        this.cp = cp;
    }

    public void closeResources(Connection c, PreparedStatement ps, ResultSet rs){
        try{
            if (c!=null){
                c.close();
            }if (ps!=null){
                ps.close();
            }if (rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            logger.error("Error closing resources in closeResources(), AbstractJdbcDao: ", e);
        }
    }


    public void closeDeleteResources(Connection c, PreparedStatement ps){
        try{
            if (c!=null){
                c.close();
            }if(ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            logger.error("Error closing delete resources in closeDeleteResources(), AbstractJdbcDao: ", e);
        }
    }




}
