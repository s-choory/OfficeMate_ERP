package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.mapper.UserMapper;

@Service
public class NoticeService{

	@Autowired
	NoticeMapper noticeMapper;

	public List<NoticeDTO> noticeAll() {
		return noticeMapper.noticeAll();
	}
	
	public int noticeAdd(NoticeDTO noticeDTO) {
		int n = noticeMapper.AddNotice(noticeDTO.getTitle(), noticeDTO.getContent(), noticeDTO.getPostedBy());
		return n;
	}


}
	

