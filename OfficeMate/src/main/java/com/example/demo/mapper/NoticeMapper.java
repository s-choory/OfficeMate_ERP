package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.dto.JoinDTO;
import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.UserDTO;
	
@Mapper
public interface NoticeMapper {
    
    
    @Insert("INSERT INTO Notices (title, content, postedBy, postDate) VALUES \n (#{title}, #{content}, #{postedBy}, now())")
    int AddNotice(@Param("title") String title, @Param("content") String content, @Param("postedBy") int postedBy);

    @Select("Select * from Notices")
	List<NoticeDTO> noticeAll();
} 
