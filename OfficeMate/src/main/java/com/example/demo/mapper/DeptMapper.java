package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.DeptDTO;

@Mapper
public interface DeptMapper {

	@Select("Select * from departments order by departmentId")
	List<DeptDTO> getDeptAll();

	@Select("Select * from departments where departmentId = #{departmentId}")
	DeptDTO getDeptOne(int departmentId);

	@Insert("INSERT INTO departments (departmentName) values (#{departmentName})")
	int insertDept(String departmentName);

	@Select("Select * from departments where departmentName = #{departmentName}")
	DeptDTO getDeptOneName(String departmentName);

	@Update("Update departments Set departmentName=#{departmentName} WHERE departmentId = #{departmentId} ")
	int updateDept(int departmentId, String departmentName);

	@Delete("Delete from departments where departmentId = #{departmentId}")
	int deptDelete(int departmentId);

}
