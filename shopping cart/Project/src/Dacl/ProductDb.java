package Dacl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDb {
	public Connection conn;
	public PreparedStatement ps;
	public ProductDb()throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("Error driver class not found");
		}
		
		conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample", "escanor", "Demo_123");
	}

}
