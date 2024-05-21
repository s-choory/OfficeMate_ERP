package com.example.demo.dto;

import java.sql.Timestamp;

public class AttendanceDTO {

	private int attendanceId;
    private int userId;
    private String checkIn;
    private String checkOut;
    private String date;
    
	public AttendanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttendanceDTO(int attendanceId, int userId, String checkIn, String checkOut, String date) {
		super();
		this.attendanceId = attendanceId;
		this.userId = userId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.date = date;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "AttendanceDTO [attendanceId=" + attendanceId + ", userId=" + userId + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + ", date=" + date + "]";
	}
	
    
	
}
