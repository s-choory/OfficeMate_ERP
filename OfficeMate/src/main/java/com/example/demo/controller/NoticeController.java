package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.NoticeDTO;
import com.example.demo.service.NoticeService;



@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
    @GetMapping("/notice")
    public String notice(Model model) {
    	List<NoticeDTO> list = noticeService.noticeAll();
    	model.addAttribute("noticeList",list);
        return "notice/notice"; 
    }
    
    @GetMapping("/notice_add")
    public String notice_add() {
        return "notice/notice_add";
    }
    
    @GetMapping("/noticeAddConfirm")
    public String noticeAddConfirm(NoticeDTO noticeDTO) {
    	noticeDTO.setPostedBy(1);	//userid get,set하기.
    	int n = noticeService.noticeAdd(noticeDTO);
    	System.out.println(n);
        return "redirect:/notice";
    }

}
