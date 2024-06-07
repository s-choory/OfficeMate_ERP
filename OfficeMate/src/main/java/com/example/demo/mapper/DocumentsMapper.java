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

	@Select("WITH LatestDocuments AS (" +
	        "    SELECT *, ROW_NUMBER() OVER (PARTITION BY documentId ORDER BY version DESC) as rn " +
	        "    FROM documents" +
	        ") " +
	        "SELECT count(*) FROM LatestDocuments " +
	        "WHERE version = 1")
	int documentsGetCount();

    @Select("WITH LatestDocuments AS (" +
            "    SELECT *, ROW_NUMBER() OVER (PARTITION BY documentId ORDER BY version DESC) as rn " +
            "    FROM documents" +
            ") " +
            "SELECT * FROM LatestDocuments " +
            "WHERE version = 1" +
            "ORDER BY documentId DESC " +
            "LIMIT #{rowCount} OFFSET #{offset}")
    List<DocumentDTO> getListAdminPage(PageDTO pageDTO);

    @Select("WITH LatestDocuments AS (" +
            "    SELECT *, ROW_NUMBER() OVER (PARTITION BY documentId ORDER BY version DESC) as rn " +
            "    FROM documents" +
            ") " +
            "SELECT count(*) FROM LatestDocuments " +
            "WHERE version = 1 AND (uploadUser = #{name} OR shareUser = #{name}) ")
	int documentgetCount(String name);

    @Select("WITH LatestDocuments AS (" +
            "    SELECT *, ROW_NUMBER() OVER (PARTITION BY documentId ORDER BY version DESC) as rn " +
            "    FROM documents" +
            ") " +
            "SELECT * FROM LatestDocuments " +
            "WHERE version = 1 AND (uploadUser = #{name} OR shareUser = #{name}) " +
            "ORDER BY documentId DESC " +
            "LIMIT #{pageDTO.rowCount} OFFSET #{pageDTO.offset}")
    List<DocumentDTO> getListPage(PageDTO pageDTO, String name);

	@Insert("INSERT INTO Documents (documentName, description, uploadedBy, uploadDate, files, fileName, uploadUser, shareUser,version, previousVersionId) VALUES "
	        + "(#{documentName}, #{description}, #{uploadedBy}, now(), #{files}, #{fileName}, #{uploadUser}, #{shareUser},#{version}, #{previousVersionId})")
	int documentAdd(DocumentDTO documentDTO);

	@Select("Select * from Documents WHERE documentId = #{documentId} ")
	DocumentDTO documentOne(Integer documentId);

	@Update("Update Documents SET documentName=#{documentName}, description=#{description}, updateDate=now() WHERE documentId = #{documentId}")
	int documentEdit(DocumentDTO documentDTO);

	@Update("Update Documents SET files=#{files}, fileName=#{fileName} WHERE documentId = #{documentId}")
	int documentEditFile(DocumentDTO documentDTO);

	@Delete("Delete from Documents WHERE documentId = #{documentId} or previousVersionId=#{documentId}" )
	int documentDelete(Integer documentId);

    @Update("UPDATE documents SET shareUser = #{userName} WHERE documentId = #{documentId} OR previousVersionId = #{documentId}")
	int documentEditShareUser(String userName, int documentId);

    @Select("SELECT * FROM documents WHERE documentId = #{documentId} OR previousVersionId = #{documentId} ORDER BY version DESC")
    List<DocumentDTO> getVersions(Integer documentId);

    @Select("SELECT count(*) FROM documents where previousVersionId = #{documentId}")
	int getCountOldDocument(int documentId);

    @Update("Update Documents Set updateDate=now() where documentId = #{previousVersionId}")
	int updatedate(int previousVersionId);

}
