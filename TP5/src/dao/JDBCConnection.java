package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author adrien
 */
public class JDBCConnection {
        
	 private static String url= "jdbc:mysql://localhost:3306/deplacements";
	 private static String user = "root";
	 private static String mdp = "root";
	
	
	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url, user, mdp);
	}

	public static void closeConnection(Connection con, Statement st, ResultSet rs) throws SQLException{
		if(con!=null)
			con.close();
		if(st!=null)
			st.close();
		if(rs!=null)
			rs.close();
	}
}
