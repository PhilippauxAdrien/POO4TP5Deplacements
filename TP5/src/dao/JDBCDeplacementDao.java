package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;
import metier.Deplacement;

/**
 *
 * @author adrien
 */
public class JDBCDeplacementDao implements DeplacementDao {

    Connection con = null;
    Statement st = null;

    @Override
    public boolean deleteAll() {
        String sql = "delete from DEPLACEMENT";
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

    @Override
    public boolean create(Deplacement d) throws DaoException {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(d.getDate());
        Long idUsager;
        if (d.getnUsager() != null) {
            idUsager = d.getnUsager().getId();System.out.println("non null");
            System.out.println("idUsager :" + d.getnUsager().getId());
        } else {
            idUsager = null;
            System.out.println("null");
        }
        String sql = "insert into DEPLACEMENT(date,mode,distanceParcourue,jourTravaille,idUsager) values('" + date + "','" + d.getMode() + "'," + d.getDistanceparcourue() + "," + d.getJourtravaille() + "," + idUsager + ")";
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return true;
    }

    @Override
    public boolean update(Deplacement obj) throws DaoException {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(obj.getDate());
        Long idUsager;
        if (obj.getnUsager() == null) {
            idUsager = null;
        } else {
            idUsager = obj.getnUsager().getId();
        }
        String sql = "update DEPLACEMENT set mode='" + obj.getMode() + "', date=" + date + ", distanceParcourue=" + obj.getDistanceparcourue() + ", jourTravaille=" + obj.getJourtravaille() + ", idUsager=" + idUsager + " where id=" + obj.getId();
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
    public boolean delete(Deplacement obj) throws DaoException {
        String sql = "delete from DEPLACEMENT where id=" + obj.getId();
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
    public Deplacement find(Integer id) {
        String sql = "select * from DEPLACEMENT where id=" + id;
        StringBuilder sb = new StringBuilder();
        ResultSet rs = null;
        Deplacement dep = null;
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                dep = new Deplacement();
                dep.setId(new Long(rs.getInt(1)));
                dep.setDate(rs.getDate(2));
                dep.setMode(rs.getString(3));
                dep.setDistanceparcourue(rs.getDouble(4));
                dep.setJourtravaille(rs.getBoolean(5));
                JDBCUsagerDao u = new JDBCUsagerDao();
                dep.setnUsager(u.find(rs.getInt(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return dep;
    }

    @Override
    public Collection<Deplacement> findAll() {
        String sql = "select * from DEPLACEMENT";
        StringBuilder sb = new StringBuilder();
        ResultSet rs = null;
        Collection<Deplacement> deps = new HashSet<>();
        try {
            con = JDBCConnection.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                Deplacement dep = new Deplacement();
                dep = new Deplacement();
                dep.setId(new Long(rs.getInt(1)));
                dep.setDate(rs.getDate(2));
                dep.setMode(rs.getString(3));
                dep.setDistanceparcourue(rs.getDouble(4));
                dep.setJourtravaille(rs.getBoolean(5));
                JDBCUsagerDao u = new JDBCUsagerDao();
                dep.setnUsager(u.find(rs.getInt(6)));
                deps.add(dep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return deps;
    }

}
