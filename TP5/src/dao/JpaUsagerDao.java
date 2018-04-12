package dao;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import metier.Usager;

/**
 *
 * @author adrien
 */
public class JpaUsagerDao extends JpaDao<Usager> implements UsagerDao{

     private JpaUsagerDao() {
        super();
    }
    private static JpaUsagerDao instance;

     protected static JpaUsagerDao getInstance() {
        if(instance == null)
            instance = new JpaUsagerDao();
        return instance;
    }
     
    @Override
    public Usager find(Integer id) {
        return em.find(Usager.class, id);
    }

    @Override
    public Collection<Usager> findAll() {
       return em.createNamedQuery("Usager.findAll").getResultList();
    }

    @Override
    public boolean deleteAll(){
        try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.createNamedQuery("Usager.deleteAll").executeUpdate();
            et.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return true;        
    }

}
