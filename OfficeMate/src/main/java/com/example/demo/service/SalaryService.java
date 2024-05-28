package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalaryDTO;
import com.example.demo.mapper.MonthSalaryMapper;
import com.example.demo.mapper.SalaryMapper;

@Service
public class SalaryService{
	
	@Autowired
	MonthSalaryMapper monthSalaryMapper;
	@Autowired
	SalaryMapper salaryMapper;

	public void userSalaryPayment(SalaryDTO salaryDTO) {
		salaryMapper.userSalaryPayment(salaryDTO);
	}


	public List<SalaryDTO> getSalaryUser(int userId) {
		return salaryMapper.getSalaryUser(userId);
	}


	public List<SalaryDTO> getSalary(LocalDate paymentMonth) {
		return salaryMapper.getSalary(paymentMonth);
	}


	public SalaryDTO getSalaryOne(int salaryId) {
		return salaryMapper.getSalaryOne(salaryId);
	}


}
