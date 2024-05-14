package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.DeptMapper;
import com.example.demo.mapper.UserMapper;

@Service
public class DeptService{

	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private UserMapper userMapper;

	public List<DeptDTO> getDeptAll() {
		return deptMapper.getDeptAll();
	}

	public DeptDTO getDeptOne(int departmentId) {
		return deptMapper.getDeptOne(departmentId);
	}
	
	public List<UserDTO> getDeptUser(int departmentId) {
		return userMapper.getDeptUser(departmentId);
	}

	public UserDTO findByUsername(String name) {
		return userMapper.findByUsername(name);
	}

	public int insertDept(String departmentName) {
		return deptMapper.insertDept(departmentName);
	}

	public DeptDTO getDeptOneName(String departmentName) {
		return deptMapper.getDeptOneName(departmentName);
	}

	public int updateDept(int departmentId, String departmentName) {
		return deptMapper.updateDept(departmentId, departmentName);
	}

	public int deptDelete(int departmentId) {
		return deptMapper.deptDelete(departmentId);
	}


	
}
