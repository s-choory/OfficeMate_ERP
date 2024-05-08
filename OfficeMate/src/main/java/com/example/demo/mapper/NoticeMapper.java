package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.relational.core.sql.From;

import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.PageDTO;
	
@Mapper
public interface NoticeMapper {
    
	@Select("Select count(*) from Notices")
	int noticeGetCount();
	
    @Insert("INSERT INTO Notices (title, content, postedBy, postDate, updateDate) VALUES \n (#{title}, #{content}, #{postedBy}, now(), null)")
    int AddNotice(@Param("title") String title, @Param("content") String content, @Param("postedBy") int postedBy);

    @Select("SELECT * from Notices order by noticeId desc LIMIT #{rowCount} OFFSET #{offset}")
	List<NoticeDTO> getListPage(PageDTO pageDTO);

    @Select("Select * from Notices WHERE noticeId = #{noticeId}")
	NoticeDTO noticeOne(Integer noticeId);

    @Update("Update Notices SET title=#{title}, content=#{content}, updateDate=now() WHERE noticeId = #{noticeId}")
	int noticeEdit(int noticeId, String title, String content);

    @Delete("Delete FROM Notices WHERE noticeId=#{noticeId}")
	int noticeDelete(Integer noticeId);



	
} 
