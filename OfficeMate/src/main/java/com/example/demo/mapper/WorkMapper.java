package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.PageDTO;
import com.example.demo.dto.WorkDTO;
	
@Mapper
public interface WorkMapper {

    @Insert("INSERT INTO Works (workName, description, assignedTo, dueDate, departmentsId, status) VALUES \n (#{workName}, #{description}, #{assignedTo}, #{dueDate}, #{departmentsId}, 'Pending')")
	int workAdd(WorkDTO workDTO);

    @Select("Select count(*) from Works where assignedTo = #{assignedTo} and status IN ('Pending', 'In progress')")
	int workGetCount(int assignedTo);
    
	@Select("SELECT * from Works where assignedTo=#{assignedTo} and status IN ('Pending', 'In progress') order by dueDate LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
	List<WorkDTO> getListUserpage(PageDTO pageDTO, int assignedTo);

	@Update("Update Works SET status=#{status} where workId=#{workId} ")
	int updateStatus(int workId, String status);
	
    @Select("Select count(*) from Works where assignedTo = #{assignedTo} and status IN ('Complete')")
	int workConfirmGetCount(int assignedTo);
    
	@Select("SELECT * from Works where assignedTo=#{assignedTo} and status IN ('Complete') order by dueDate LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
	List<WorkDTO> getListConfirmUserPage(PageDTO pageDTO, int assignedTo);

    
	
} 
