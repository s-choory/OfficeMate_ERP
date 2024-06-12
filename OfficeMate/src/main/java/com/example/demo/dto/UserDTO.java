package com.example.demo.dto;

import java.util.Arrays;

public class UserDTO {

	private int userId;
	private String username;
	private String email;
	private String password;
	private int departmentId;
	private String userRank;
	private String userPosition;
	private String role;
	private int monthSalary;
	private String hiredate;
	private String gender;
	private String phone;
	private String birth;
	private byte[] userImg;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", departmentId=" + departmentId + ", userRank=" + userRank + ", userPosition=" + userPosition
				+ ", role=" + role + ", monthSalary=" + monthSalary + ", hiredate=" + hiredate + ", gender=" + gender
				+ ", phone=" + phone + ", birth=" + birth + ", userImg=" + Arrays.toString(userImg) + "]";
	}

	public String getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(String userPosition) {
		this.userPosition = userPosition;
	}

	public UserDTO(int userId, String username, String email, String password, int departmentId, String userRank,
			String userPosition, String role, int monthSalary, String hiredate, String gender, String phone,
			String birth, byte[] userImg) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.departmentId = departmentId;
		this.userRank = userRank;
		this.userPosition = userPosition;
		this.role = role;
		this.monthSalary = monthSalary;
		this.hiredate = hiredate;
		this.gender = gender;
		this.phone = phone;
		this.birth = birth;
		this.userImg = userImg;
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

	public int getMonthSalary() {
		return monthSalary;
	}

	public void setMonthSalary(int monthSalary) {
		this.monthSalary = monthSalary;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public byte[] getUserImg() {
		return userImg;
	}

	public void setUserImg(byte[] userImg) {
		this.userImg = userImg;
	}

}
