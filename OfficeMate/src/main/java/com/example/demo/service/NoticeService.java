package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.mapper.NoticeMapper;

@Service
public class NoticeService{

	@Autowired
	NoticeMapper noticeMapper;


	public int noticeGetCount() {
		return noticeMapper.noticeGetCount();
		
	}
	
	public int noticeAdd(NoticeDTO noticeDTO) { 
		return noticeMapper.AddNotice(noticeDTO);
	}

	public NoticeDTO noticeOne(Integer noticeId) {
		return noticeMapper.noticeOne(noticeId);
	}

	public int noticeEdit(NoticeDTO noticeDTO) {
		return noticeMapper.noticeEdit(noticeDTO.getNoticeId(), noticeDTO.getTitle(), noticeDTO.getContent());
	}

	public int noticeDelete(Integer noticeId) {
		return noticeMapper.noticeDelete(noticeId);
	}

	public List<NoticeDTO> getListPage(PageDTO pageDTO) {
		return noticeMapper.getListPage(pageDTO);
	}

	public void uploadImage(String fileName, MultipartFile file) {
		
		
	}

}
	

