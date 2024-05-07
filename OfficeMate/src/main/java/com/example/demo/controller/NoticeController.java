package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @GetMapping("/admin/notice_add")
    public String notice_add() {
        return "notice/notice_add";
    }
    
    @GetMapping("/admin/noticeAddConfirm")
    public String noticeAddConfirm(NoticeDTO noticeDTO) {
    	noticeDTO.setPostedBy(1);	//userid get,set하기.
    	int n = noticeService.noticeAdd(noticeDTO);
    	System.out.println(n);
        return "redirect:/notice";
    }
    
    @GetMapping("/notice/{noticeId}")
    public String noticeContent(@PathVariable Integer noticeId, Model model) {
    	NoticeDTO noticeDTO = noticeService.noticeOne(noticeId);
    	model.addAttribute("notice", noticeDTO);
    	return "notice/notice_content";
    }
    
    @GetMapping("/admin/noticeEdit/{noticeId}")
    public String noticeEdit(@PathVariable Integer noticeId, Model model) {
    	NoticeDTO noticeDTO = noticeService.noticeOne(noticeId);
    	model.addAttribute("notice", noticeDTO);
    	return "notice/notice_edit";
    }
    
    @GetMapping("/admin/noticeEditConfirm")
    public String noticeEditConfirm(NoticeDTO noticeDTO) {
    	int n = noticeService.noticeEdit(noticeDTO);
    	System.out.println(n);
    	return "redirect:/notice/"+noticeDTO.getNoticeId();
    }
    
    @GetMapping("/admin/noticeDelete")
    public String noticeDelete(@RequestParam Integer noticeId) {
    	int n = noticeService.noticeDelete(noticeId);
    	System.out.println(n);
    	return "redirect:/notice";
    }
}
