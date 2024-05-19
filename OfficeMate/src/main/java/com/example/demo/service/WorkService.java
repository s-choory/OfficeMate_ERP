package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PageDTO;
import com.example.demo.dto.WorkDTO;
import com.example.demo.mapper.WorkMapper;

@Service
public class WorkService{

	@Autowired
	private WorkMapper workMapper;

	public int workGetCount(int assignedTo) {
		return workMapper.workGetCount(assignedTo);
	}
	
	public int workAdd(WorkDTO workDTO) {
		return workMapper.workAdd(workDTO);
	}

	public List<WorkDTO> getListUserPage(PageDTO pageDTO, int assignedTo) {
		return workMapper.getListUserpage(pageDTO, assignedTo);
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

	public void deleteWork(int workId) {
		workMapper.deleteWork(workId);
		
	}





	
}
