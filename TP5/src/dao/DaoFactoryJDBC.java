package dao;

/**
 *
 * @author adrien
 */
public class DaoFactoryJDBC extends DaoFactory {

    protected DaoFactoryJDBC() {

    }

    @Override
    public JDBCUsagerDao getUsagerDao() {
        return new JDBCUsagerDao();
    }

    @Override
    public JDBCDeplacementDao getDeplacementDao() {
        return new JDBCDeplacementDao();
    }

}
