package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.mapper.AttendanceMapper;

@Service
public class AttendanceService{

	@Autowired
	AttendanceMapper attendanceMapper;

	public int checkIn(AttendanceDTO attendanceDTO) {
		return attendanceMapper.checkIn(attendanceDTO);
	}

	public AttendanceDTO getTodayAttendanceByUserId(int userId) {
		return attendanceMapper.getTodayAttendanceByUserId(userId);
	}

	public int checkOut(AttendanceDTO attendanceDTO) {
		return attendanceMapper.checkOut(attendanceDTO);
	}

}
	

