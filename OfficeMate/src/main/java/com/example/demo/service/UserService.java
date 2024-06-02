package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SalaryDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService{

	@Autowired
	private UserMapper userMapper;
	
	public UserDTO getUserById(int userId) {
		return userMapper.getUserById(userId);
	}

	public UserDTO getUserByName(String username) {
		return userMapper.findByUsername(username);
	}

	public List<UserDTO> getUserByNamIncluded(String userName) {
		return userMapper.findByUsernameIncluded(userName);
	}

	public List<UserDTO> getUserAll() {
		return userMapper.getUserAll();
	}

	public int updateUserDetail(UserDTO userDTO) {
		return userMapper.updateUserDetail(userDTO);
	}

	public int deleteUser(int userId) {
		return userMapper.deleteUser(userId);
	}

	public BigDecimal getUserTotalAmount() {
		return userMapper.getUserTotalAmount();
	}

	public List<UserDTO> getMonthSalaryUser(List<SalaryDTO> salaryList) {
		List<UserDTO> userList = new ArrayList<>();
		for (SalaryDTO salaryDTO : salaryList) {
			userList.add(userMapper.getUserById(salaryDTO.getUserId()));
		}
		return userList;
	}

	
}
