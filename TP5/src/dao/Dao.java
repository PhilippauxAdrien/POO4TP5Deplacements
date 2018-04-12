/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;

/**
 *
 * @author adrie
 */
public interface Dao<T> {
    
    public boolean create(T obj) throws DaoException;
    public T find(Integer id);
    public Collection<T> findAll();
    public boolean update(T obj) throws DaoException;
    public boolean delete(T obj) throws DaoException;
    public boolean deleteAll();
    public void close();    
    
}
