package Dacl;
import java.sql.*;

public class UserDb {
	public Connection conn;
	public PreparedStatement ps;
	public UserDb()throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("Error driver class not found");
		}
		
		conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample", "escanor", "Demo_123");
	}
}
