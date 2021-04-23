package com.solvd.townhall.dao.interfaces;

public interface IEntityDAO <T>{
    public void save(T entity);
    public void update(T entity);
    public T getById(long id);
    public void delete(T entity);
}
