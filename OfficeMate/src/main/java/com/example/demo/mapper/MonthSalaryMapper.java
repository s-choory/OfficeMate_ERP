package com.example.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.MonthSalaryDTO;
	
@Mapper
public interface MonthSalaryMapper {

    @Select("SELECT * FROM MonthlyPaymentSummary WHERE paymentMonth = #{paymentMonth}")
    MonthSalaryDTO findByPaymentMonth(LocalDate paymentMonth);

    @Insert("INSERT INTO MonthlyPaymentSummary (paymentMonth, paymentDescription, totalAmount) VALUES (#{paymentMonth}, #{paymentDescription}, #{totalAmount})")
	int addMonthSalary(MonthSalaryDTO monthSalaryDTO);

    @Select("SELECT * FROM MonthlyPaymentSummary")
	List<MonthSalaryDTO> getAllMonthSalary();

    
	
} 
