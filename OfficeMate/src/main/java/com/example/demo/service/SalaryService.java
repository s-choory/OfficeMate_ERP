package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalaryDTO;
import com.example.demo.mapper.MonthSalaryMapper;
import com.example.demo.mapper.SalaryMapper;

@Service
public class SalaryService {

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

	public List<Integer> getSalaryList(LocalDate paymentMonth) {
		return salaryMapper.getSalaryList(paymentMonth);
	}

	public SalaryDTO getSalaryOne(int userId, LocalDate paymentMonth) {
		return salaryMapper.getSalaryOne2(userId, paymentMonth);
	}

	public boolean payBonus(int salaryId, int bonus) {
		return salaryMapper.payBouns(salaryId, bonus);
	}

}
