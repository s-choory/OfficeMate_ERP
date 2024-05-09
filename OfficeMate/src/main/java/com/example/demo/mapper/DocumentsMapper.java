package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.DocumentDTO;
import com.example.demo.dto.PageDTO;
	
@Mapper
public interface DocumentsMapper {

	@Select("Select count(*) from documents")
	int documentsGetCount();
    
	@Select("SELECT * from Documents order by documentId desc LIMIT #{rowCount} OFFSET #{offset}")
	List<DocumentDTO> getListPage(PageDTO pageDTO);
    
	
} 
