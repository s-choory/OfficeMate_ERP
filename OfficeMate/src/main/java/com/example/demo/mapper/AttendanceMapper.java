package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.AttendanceDTO;
	
@Mapper
public interface AttendanceMapper {

	@Insert("Insert INTO attendance (userId, checkIn, date) VALUES (#{userId}, #{checkIn}, now())")
	int checkIn(AttendanceDTO attendanceDTO);

	@Select("SELECT * FROM attendance WHERE userId = #{userId} AND date_trunc('day', date) = date_trunc('day', now())")
	AttendanceDTO getTodayAttendanceByUserId(int userId);

	@Update("UPDATE attendance SET checkOut = #{checkOut} WHERE userId = #{userId} AND date_trunc('day', date) = date_trunc('day', now())")
	int checkOut(AttendanceDTO attendanceDTO);


} 
