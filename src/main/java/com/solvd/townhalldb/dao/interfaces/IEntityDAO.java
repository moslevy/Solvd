package com.solvd.townhalldb.dao.interfaces;

import java.sql.SQLException;

public interface IEntityDAO <T>{
    public void save(T entity) throws SQLException;
    public void update(T entity) throws SQLException;
    public T getById(long id) throws SQLException;
    public void delete(T entity) throws SQLException;
}
