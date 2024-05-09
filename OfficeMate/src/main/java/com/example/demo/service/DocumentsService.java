package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DocumentDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.mapper.DocumentsMapper;

@Service
public class DocumentsService{

	@Autowired
	DocumentsMapper documentsMapper;

	public int documentsGetCount() {
		return documentsMapper.documentsGetCount();
	}

	public List<DocumentDTO> getListPage(PageDTO pageDTO) {
		return documentsMapper.getListPage(pageDTO);
	}

}
	

