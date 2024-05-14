package com.example.demo.dto;

public class UserDTO {
	
	private int userId;
	private String username;
	private String email;
	private String password;
	private int departmentId;
	private String userRank;
	private String role;
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int userId, String username, String email, String password, int departmentId, String userRank,
			String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.departmentId = departmentId;
		this.userRank = userRank;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", departmentId=" + departmentId + ", userRank=" + userRank + ", role=" + role + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getUserRank() {
		return userRank;
	}
	
	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
