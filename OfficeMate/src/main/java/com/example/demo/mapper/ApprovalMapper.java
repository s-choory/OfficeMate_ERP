package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.ApprovalDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;

@Mapper
public interface ApprovalMapper {

	@Select("SELECT count(*) FROM approval WHERE creator=#{name} and status = 'pending'")
	int approvalGetCount(String name);

	@Select("Select count(*) FROM approval WHERE department=#{deptName} and status = 'pending'")
	int approvalGetCountDept(String deptName);

	@Select("SELECT * FROM approval WHERE creator=#{name} and status = 'pending' order by approvalId desc LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
	List<ApprovalDTO> getList(String name, PageDTO pageDTO);

	@Select("SELECT * FROM approval WHERE department=#{deptName} and status = 'pending' order by approvalId desc LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
	List<ApprovalDTO> getListDept(String deptName, PageDTO pageDTO);

	@Select("SELECT count(*) FROM approval WHERE creator=#{name} and status = 'complete'")
	int approvalGetCountComplete(String name);

	@Select("Select count(*) FROM approval WHERE department=#{deptName} and status = 'complete'")
	int approvalGetCountDeptComplete(String deptName);

	@Select("SELECT * FROM approval WHERE creator=#{name} and status = 'complete' order by approvalId desc LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
	List<ApprovalDTO> getListComplete(String name, PageDTO pageDTO);

	@Select("SELECT * FROM approval WHERE department=#{deptName} and status = 'complete' order by approvalId desc LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
	List<ApprovalDTO> getListDeptComplete(String deptName, PageDTO pageDTO);

	@Insert("INSERT INTO approval (title, creator, department, content, remarks, attachments) VALUES (#{title}, #{creator}, #{department}, #{content}, #{remarks}, #{attachments});")
	int approvalAdd(ApprovalDTO approvalDTO);

	@Select("Select * From approval where approvalId = #{approvalId}")
	ApprovalDTO getApprovalOne(Integer approvalId);

	@Update("Update approval set managerApproval = now() where approvalId = #{approvalId}")
	void approveManager(Long approvalId);

	@Update("Update approval set departmentHeadApproval = now() where approvalId = #{approvalId}")
	void approveDepartmentHead(Long approvalId);

	@Update("Update approval set ceoApproval = now(), status='complete' where approvalId = #{approvalId}")
	void ceoApproval(Long approvalId);

	@Select("SELECT count(*) FROM approval WHERE status = 'pending'")
	int approvalGetCountAll();

	@Select("SELECT * FROM approval where status = 'pending' order by approvalId desc LIMIT #{rowCount} OFFSET #{offset}")
	List<ApprovalDTO> getListAll(PageDTO pageDTO);

	@Select("SELECT count(*) FROM approval WHERE status = 'complete'")
	int approvalGetCountCompleteAll();

	@Select("SELECT * FROM approval where status = 'complete' order by approvalId desc LIMIT #{rowCount} OFFSET #{offset}")
	List<ApprovalDTO> getListCompleteAll(PageDTO pageDTO);

}
