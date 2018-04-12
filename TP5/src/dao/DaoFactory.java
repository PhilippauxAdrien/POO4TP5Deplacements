package dao;

/**
 *
 * @author adrien
 */
public abstract class DaoFactory {
    public enum PersistenceType {
        JPA,
        JDBC,
        XML
    };
    
    public static DaoFactory getDaoFactory(PersistenceType type) {
        switch(type) {
            case JPA:
                return new DaoFactoryJpa();
            case JDBC:
                return new DaoFactoryJDBC();
            case XML:
                throw new UnsupportedOperationException("Not implemented yet.");
            default:
                return null;
        }
    }
    
    public abstract UsagerDao getUsagerDao();
    
    public abstract DeplacementDao getDeplacementDao();

  
}