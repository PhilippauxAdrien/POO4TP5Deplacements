package dao;

import java.util.Collection;
import javax.persistence.EntityTransaction;
import metier.Deplacement;

/**
 *
 * @author adrien
 */
public class JpaDeplacementDao extends JpaDao<Deplacement> implements DeplacementDao{

    private JpaDeplacementDao() {
        super();
    }
    private static JpaDeplacementDao instance;

     protected static JpaDeplacementDao getInstance() {
        if(instance == null)
            instance = new JpaDeplacementDao();
        return instance;
    }
     
    @Override
    public Deplacement find(Integer id) {
        return em.find(Deplacement.class, id);
    }

    @Override
    public Collection<Deplacement> findAll() {
       return em.createNamedQuery("Deplacement.findAll").getResultList();
    }

    @Override
    public boolean deleteAll(){
     try{
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.createNamedQuery("Deplacement.deleteAll").executeUpdate();
            et.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return true;       
    }

}
