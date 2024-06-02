package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.DocumentDTO;
import com.example.demo.dto.PageDTO;

@Mapper
public interface DocumentsMapper {

	@Select("Select count(*) from documents")
	int documentsGetCount();

	@Select("SELECT * from Documents where uploadUser=#{name} or shareUser=#{name} order by documentId desc LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
	List<DocumentDTO> getListPage(PageDTO pageDTO, String name);

	@Select("SELECT * from Documents order by documentId desc LIMIT #{rowCount} OFFSET #{offset}")
	List<DocumentDTO> getListAdminPage(PageDTO pageDTO);

	@Insert("INSERT INTO Documents (documentName, description, uploadedBy, uploadDate, files, fileName, uploadUser) VALUES "
			+ "(#{documentName}, #{description}, #{uploadedBy}, now(), #{files}, #{fileName}, #{uploadUser})")
	int documentAdd(DocumentDTO documentDTO);

	@Select("Select * from Documents WHERE documentId = #{documentId}")
	DocumentDTO documentOne(Integer documentId);

	@Update("Update Documents SET documentName=#{documentName}, description=#{description}, updateDate=now() WHERE documentId = #{documentId}")
	int documentEdit(DocumentDTO documentDTO);

	@Update("Update Documents SET files=#{files}, fileName=#{fileName} WHERE documentId = #{documentId}")
	int documentEditFile(DocumentDTO documentDTO);

	@Delete("Delete from Documents WHERE documentId = #{documentId}")
	int documentDelete(Integer documentId);

	@Update("Update Documents Set shareUser = #{userName} where documentId = #{documentId}")
	int documentEditShareUser(String userName, int documentId);

	@Select("SELECT count(*) from Documents where uploadUser=#{name} or shareUser=#{name}")
	int documentgetCount(String name);

}
