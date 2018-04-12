package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import metier.Usager;

/**
 *
 * @author adrien
 */
public class JDBCUsagerDao implements UsagerDao {

    Connection con = null;
    Statement st = null;

    @Override
    public boolean create(Usager u) throws DaoException {
        String sql = "insert into USAGER(email,password) values('" + u.getEmail() + "','" + u.getPassword() + "')";
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
           ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
              int newId = rs.getInt(1);
              u.setId(new Long(newId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return true;
    }

    @Override
    public Usager find(Integer id) {
        String sql = "select * from USAGER where id=" + id;
        StringBuilder sb = new StringBuilder();
        ResultSet rs = null;
        Usager usager = null;
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                usager = new Usager();
                usager.setId(new Long(rs.getInt(1)));
                usager.setEmail(rs.getString(2));
                usager.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return usager;
    }
    
    public Usager find(String email) {
        String sql = "select * from USAGER where email='" + email + "'";
        StringBuilder sb = new StringBuilder();
        ResultSet rs = null;
        Usager usager = null;
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                usager = new Usager();
                usager.setId(new Long(rs.getInt(1)));
                usager.setEmail(rs.getString(2));
                usager.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return usager;
    }

    @Override
    public Collection<Usager> findAll() {
        String sql = "select * from USAGER";
        StringBuilder sb = new StringBuilder();
        ResultSet rs = null;
        Collection<Usager> usagers = new HashSet<>();
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Usager usager = new Usager();
                usager.setId(new Long(rs.getInt(1)));
                usager.setEmail(rs.getString(2));
                usager.setPassword(rs.getString(3));
                usagers.add(usager);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return usagers;
    }

    @Override
    public boolean update(Usager obj) throws DaoException {
        String sql = "update USAGER set email='" + obj.getEmail() + "', password='" + obj.getPassword() + "' where id=" + obj.getId();
        boolean flag = false;
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            if (st.executeUpdate(sql) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return flag;
    }

    @Override
    public boolean delete(Usager obj) throws DaoException {
        String sql = "delete from USAGER where id=" + obj.getId();
        boolean flag = false;
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            if (st.executeUpdate(sql) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return flag;
    }

    @Override
    public boolean deleteAll() {
        String sql = "delete from USAGER";
        boolean flag = false;
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            if (st.executeUpdate(sql) > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return flag;
    }

    @Override
    public void close() {
        try {
            JDBCConnection.closeConnection(con, st, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
