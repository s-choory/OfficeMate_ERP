package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MonthSalaryDTO;
import com.example.demo.mapper.MonthSalaryMapper;

@Service
public class MonthSalaryService{
	
	@Autowired
	MonthSalaryMapper monthSalaryMapper;

    public Optional<MonthSalaryDTO> findByPaymentMonth(LocalDate currentMonth) {
        return Optional.ofNullable(monthSalaryMapper.findByPaymentMonth(currentMonth));
    }

	public int addMonthSalary(MonthSalaryDTO monthSalaryDTO) {
		return monthSalaryMapper.addMonthSalary(monthSalaryDTO);
	}

	public List<MonthSalaryDTO> getAllMonthSalary() {
		return monthSalaryMapper.getAllMonthSalary();
	}

	public MonthSalaryDTO getMonthSalary(int monthSalaryId) {
		return monthSalaryMapper.getMonthSalary(monthSalaryId);
	}

	public void salaryPaymentComplete(LocalDate paymentMonth) {
		monthSalaryMapper.salaryPaymentComplete(paymentMonth);
	}

	public MonthSalaryDTO getMonthSalaryDTO(LocalDate paymentMonth) {
		return monthSalaryMapper.findByPaymentMonth(paymentMonth);
	}
	
}
