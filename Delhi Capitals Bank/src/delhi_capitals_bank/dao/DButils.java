package delhi_capitals_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DButils {
	
	public static Connection getConnectiontodb() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		ResourceBundle rb=ResourceBundle.getBundle("dbdetails");
		Connection conn=DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("password"));
		
		return conn;
	}
	
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn!=null)
			conn.close();
	}
	
	
	public static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			return true;
		}
		return false;
	}
	
}
