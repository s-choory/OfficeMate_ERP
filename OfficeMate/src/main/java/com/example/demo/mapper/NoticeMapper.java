package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.NoticeDTO;
	
@Mapper
public interface NoticeMapper {
    
    
    @Insert("INSERT INTO Notices (title, content, postedBy, postDate, updateDate) VALUES \n (#{title}, #{content}, #{postedBy}, now(), null)")
    int AddNotice(@Param("title") String title, @Param("content") String content, @Param("postedBy") int postedBy);

    @Select("Select * from Notices order by noticeId desc")
	List<NoticeDTO> noticeAll();

    @Select("Select * from Notices WHERE noticeId = #{noticeId}")
	NoticeDTO noticeOne(Integer noticeId);

    @Update("Update Notices SET title=#{title}, content=#{content}, updateDate=now() WHERE noticeId = #{noticeId}")
	int noticeEdit(int noticeId, String title, String content);

    @Delete("Delete FROM Notices WHERE noticeId=#{noticeId}")
	int noticeDelete(Integer noticeId);

	
} 
