package info;

public class User {
	private String username;
	private String email;
	private String password;
	
	public User(String username, String email, String password) {
		this.email = email;
		this.password = password;
		this.username = username;
	}
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
