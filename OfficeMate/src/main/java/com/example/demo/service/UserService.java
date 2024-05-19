package com.example.demo.service;

import java.util.List;

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

	
}
