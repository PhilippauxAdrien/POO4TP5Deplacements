package dao;

/**
 *
 * @author adrien
 */
public class DaoFactoryJpa extends DaoFactory{

     protected DaoFactoryJpa() {
        
    }
    
    @Override
    public JpaUsagerDao getUsagerDao() {
        return JpaUsagerDao.getInstance();
    }
    
    @Override
    public JpaDeplacementDao getDeplacementDao() {
        return JpaDeplacementDao.getInstance();
    }
   
}
