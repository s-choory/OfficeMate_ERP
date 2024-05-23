package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.SalaryDTO;
	
@Mapper
public interface SalaryMapper {

    @Insert("INSERT INTO Salary (userId, salaryDate, amount, paymentMethod, description) VALUES (#{userId}, now(), #{amount}, #{paymentMethod}, #{description})")
	void userSalaryPayment(SalaryDTO salaryDTO);

    @Select("Select * from Salary where userId = #{userId}")
	List<SalaryDTO> getSalaryUser(int userId);
	
} 
