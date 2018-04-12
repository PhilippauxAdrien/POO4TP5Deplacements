/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import dao.DaoException;
/**
 *
 * @author adrien
 * @param <T>
 */
public abstract class JpaDao<T> implements Dao<T>{
    protected EntityManager em;
    
    protected final static String PERSISTENCE_UNIT = "TP5PU";
    EntityTransaction et;

    public JpaDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        em = emf.createEntityManager();
        et = em.getTransaction();
    }
                
    @Override
    public boolean create(T t) throws DaoException{
        try {
            et.begin();
            em.persist(t);
            et.commit();
        }
        catch(Exception e) {
           e.printStackTrace();
          // throw new DaoException("Error during create", e);
        }
        return true;
    }

    @Override
    public boolean update(T t) throws DaoException{
        try {
            et.begin();
            em.merge(t);
            et.commit();
        }
        catch(Exception e) {
           throw new DaoException("Error during update", e);
        }
        return true;
    }

    @Override
    public boolean delete(T t) throws DaoException{
        
        try {
            et.begin();
            em.remove(t);
            et.commit();
        }
        catch(Exception e) {
          throw new DaoException("Error during delete", e);
        }
        return true;
    }

    @Override
    public void close(){
        if(em != null && em.isOpen()){
            em.close();
        }
    }
    
    
}