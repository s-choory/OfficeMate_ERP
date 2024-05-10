package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
}
