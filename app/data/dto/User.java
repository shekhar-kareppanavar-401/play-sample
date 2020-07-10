package data.dto;

public class User {

	private int userId;
	private String name;
	private String emailId;
	
	public User() {
		super();
	}

	public User(int userId, String name, String emailId) {
		super();
		this.userId = userId;
		this.name = name;
		this.emailId = emailId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", emailId=" + emailId + "]";
	}
	
	
	
	
}
