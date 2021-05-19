package com.solvd.townhalldb.jaxb.dao.interfaces;

public interface IEntityDAO <T>{
    public void create(T entity);
    public void update(T entity);
    public T getById(long id);
    public void delete(T entity);
}
