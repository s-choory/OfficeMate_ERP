package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PageDTO;
import com.example.demo.dto.WorkDTO;
import com.example.demo.mapper.WorkMapper;

@Service
public class WorkService {

	@Autowired
	private WorkMapper workMapper;

	public int workGetCount(int assignedTo) {
		return workMapper.workGetCount(assignedTo);
	}

	public int workGetDeptCount(int departmentId) {
		return workMapper.workGetDeptCount(departmentId);
	}

	public int workAdd(WorkDTO workDTO) {
		return workMapper.workAdd(workDTO);
	}

	public List<WorkDTO> getListUserPage(PageDTO pageDTO, int assignedTo) {
		return workMapper.getListUserpage(pageDTO, assignedTo);
	}

	public List<WorkDTO> getListDeptPage(PageDTO pageDTO, int departmentId) {
		return workMapper.getListDeptPage(pageDTO, departmentId);
	}

	public int updateStatus(int workId, String status) {
		return workMapper.updateStatus(workId, status);
	}

	public int workConfirmGetCount(int assignedTo) {
		return workMapper.workConfirmGetCount(assignedTo);
	}

	public List<WorkDTO> getListConfirmUserPage(PageDTO pageDTO, int assignedTo) {
		return workMapper.getListConfirmUserPage(pageDTO, assignedTo);
	}

	public int workConfirmDeptCount(int departmentId) {
		return workMapper.workConfirmDeptGetCount(departmentId);
	}

	public List<WorkDTO> getListConfirmDeptPage(PageDTO pageDTO, int departmentId) {
		return workMapper.getListConfirmDeptPage(pageDTO, departmentId);
	}

	public void deleteWork(int workId) {
		workMapper.deleteWork(workId);
	}

	public WorkDTO getWorkOne(Integer workId) {
		return workMapper.getWorkOne(workId);
	}

	public void updateWorkDescription(int workId, String newDescription) {
		workMapper.updateWorkDescription(workId, newDescription);
	}

	public int workAllCount() {
		return workMapper.workAllCount();
	}

	public List<WorkDTO> getListWorkAll(PageDTO pageDTO) {
		return workMapper.getListWorkAll(pageDTO);
	}

	public int workAllCountConfirm() {
		return workMapper.workAllCountConfirm();
	}

	public List<WorkDTO> getListWorkAllConfirm(PageDTO pageDTO) {
		return workMapper.getListWorkAllConfirm(pageDTO);
	}

}
