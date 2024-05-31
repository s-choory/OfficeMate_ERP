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

	public List<DocumentDTO> getListPage(PageDTO pageDTO, String name) {
		return documentsMapper.getListPage(pageDTO, name);
	}

	public List<DocumentDTO> getListAdminPage(PageDTO pageDTO) {
		return documentsMapper.getListAdminPage(pageDTO);

	}

	public int documentAdd(DocumentDTO documentDTO) {
		return documentsMapper.documentAdd(documentDTO);
	}

	public DocumentDTO documentOne(Integer documentId) {
		return documentsMapper.documentOne(documentId);
	}

	public int documentEdit(DocumentDTO documentDTO) {
		return documentsMapper.documentEdit(documentDTO);
	}

	public int documentEditFile(DocumentDTO documentDTO) {
		return documentsMapper.documentEditFile(documentDTO);
	}

	public int documentDelete(Integer documentId) {
		return documentsMapper.documentDelete(documentId);
	}

	public int updateDocumentShareUser(String userName, int documentId) {
		return documentsMapper.documentEditShareUser(userName, documentId);
	}

	public int documentgetCount(String name) {
		return documentsMapper.documentgetCount(name);
	}


}
	

