package com.solvd.townhalldb.dao.abstractClasses;


import com.solvd.townhalldb.connectionPool.ConnectionPool;

public abstract class AbstractJdbcDao {
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

}
