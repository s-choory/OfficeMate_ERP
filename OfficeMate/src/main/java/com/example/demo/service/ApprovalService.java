package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApprovalDTO;
import com.example.demo.dto.AttendanceDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.ApprovalMapper;
import com.example.demo.mapper.AttendanceMapper;

@Service
public class ApprovalService {

	@Autowired
	ApprovalMapper approvalMapper;

	public int approvalGetCount(String name) {
		return approvalMapper.approvalGetCount(name);
	}

	public int approvalGetCountDept(String deptName) {
		return approvalMapper.approvalGetCountDept(deptName);
	}

	public List<ApprovalDTO> getList(String name, PageDTO pageDTO) {
		return approvalMapper.getList(name, pageDTO);
	}

	public List<ApprovalDTO> getListDept(String deptName, PageDTO pageDTO) {
		return approvalMapper.getListDept(deptName, pageDTO);
	}

	public int approvalAdd(ApprovalDTO approvalDTO) {
		return approvalMapper.approvalAdd(approvalDTO);
	}

	public ApprovalDTO getApprovalOne(Integer approvalId) {
		return approvalMapper.getApprovalOne(approvalId);
	}

	public void approveManager(Long approvalId) {
		approvalMapper.approveManager(approvalId);
	}

	public void approveDepartmentHead(Long approvalId) {
		approvalMapper.approveDepartmentHead(approvalId);
	}

	public void approveCeo(Long approvalId) {
		approvalMapper.ceoApproval(approvalId);
	}

	public int approvalGetCountComplete(String name) {
		return approvalMapper.approvalGetCountComplete(name);

	}

	public List<ApprovalDTO> getListComplete(String name, PageDTO pageDTO) {
		return approvalMapper.getListComplete(name, pageDTO);
	}

	public int approvalGetCountDeptComplete(String deptName) {
		return approvalMapper.approvalGetCountDeptComplete(deptName);
	}

	public List<ApprovalDTO> getListDeptComplete(String deptName, PageDTO pageDTO) {
		return approvalMapper.getListDeptComplete(deptName, pageDTO);

	}

	public int approvalGetCountAll() {
		return approvalMapper.approvalGetCountAll();
	}

	public List<ApprovalDTO> getListAll(PageDTO pageDTO) {
		return approvalMapper.getListAll(pageDTO);
	}

	public int approvalGetCountCompleteAll() {
		return approvalMapper.approvalGetCountCompleteAll();
	}

	public List<ApprovalDTO> getListCompleteAll(PageDTO pageDTO) {
		return approvalMapper.getListCompleteAll(pageDTO);
	}

}
