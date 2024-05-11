package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.UserDTO;
	
@Mapper
public interface DeptMapper {

	@Select("Select * from departments")
	List<DeptDTO> getDeptAll();

	@Select("Select * from departments where departmentId = #{departmentId}")
	DeptDTO getDeptOne(int departmentId);
    
} 
