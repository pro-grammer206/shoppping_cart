package Dacl;

import java.sql.ResultSet;
import java.sql.SQLException;
import Dacl.UserInfoValidation;

public class User extends UserDb {

	public User() throws SQLException {
		super();
	}
	private String name;
	private String email;
	private String mobile;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean updateUser(UserInfoValidation u) {
		User us;
		int rs=0;
		try {
			us = new User();
			us.setName(u.getUserName());
			us.setEmail(u.getEmail());
			us.setMobile(u.getMobile());
			us.setPassword(u.getPassword());
			ps=conn.prepareStatement("INSERT INTO users VALUES(null,?,?,?,?,?)");
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getMobile());
			ps.setString(4, us.getPassword());
			ps.setInt(5, 0);
		 rs = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0) {
			System.out.println(rs);
			return true;
			
		}else {
			return false;
		}
		
	}
	
	public boolean validation(String name,String pass)throws SQLException {
		ResultSet rs;
			ps=conn.prepareStatement("SELECT password FROM users WHERE name=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) 
				if(rs.getString("password").equals(pass))
				return true;
				else
					return false;
			else 
				return false;
		
		}
	
	
	

}
