package Dacl;

import java.util.regex.*;

public class UserInfoValidation {
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	private String email;
	private String mobile;
	private String password;
	private static Pattern pattern;
	private Matcher matcher;
	private static final String  EMAIL_PATTERN="^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	public int isEmailValid(String email) {
		if(email.isEmpty()) {
			System.out.println("email is empty");
			return 1;
		}
		else {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(email);
			if(matcher.matches()) {
				System.out.println("email is correct");
				return 2;
			}
			else {
				System.out.println("email is incorrect");
			    return 3;	
			}
		}
	}
	public int fieldsValid(String username,String mobile) {
		if(username.isEmpty() && mobile.isEmpty())
			return 1;
		else 
			return 2;
		
	}
	public int passwordValid(String pass,String repass) {
		if(pass.isEmpty()&& repass.isEmpty()) {
			System.out.println("Fields are empty");
			return 1;
			}
		else
		{
			if(pass.equals(repass)) {
				System.out.println("fields are of same value");
				return 2;
				}
			else {
				System.out.println("mismatch");
				return 3;
			}
			
		}
	}
}

