package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.NoticeDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@GetMapping("/notice")
	public String notice(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		PageDTO pageDTO = new PageDTO(noticeService.noticeGetCount(), page);
		List<NoticeDTO> list = noticeService.getListPage(pageDTO);
		model.addAttribute("noticeList", list);
		model.addAttribute("page", page);
		model.addAttribute("pageDTO", pageDTO);
		return "notice/notice";
	}

	@GetMapping("/admin/notice_add")
	public String notice_add() {
		return "notice/notice_add";
	}

	@PostMapping("/admin/noticeAddConfirm")
	public String noticeAddConfirm(NoticeDTO noticeDTO, @RequestParam("files") MultipartFile file) {

		try {
			noticeDTO.setFile(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		noticeDTO.setPostedBy(1); // userid get,set하기.
		int n = noticeService.noticeAdd(noticeDTO);
		System.out.println(n);

		return "redirect:/notice";
	}

	@GetMapping("/notice/{noticeId}")
	public String noticeContent(@PathVariable Integer noticeId, Model model) {
		NoticeDTO noticeDTO = noticeService.noticeOne(noticeId);
		byte[] fileBytes = noticeDTO.getFile();
		if (fileBytes != null && fileBytes.length > 0) {
			String base64EncodedImage = Base64.getEncoder().encodeToString(fileBytes);
			model.addAttribute("base64EncodedFile", base64EncodedImage);
		}
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
		return "redirect:/notice/" + noticeDTO.getNoticeId();
	}

	@GetMapping("/admin/noticeDelete")
	public String noticeDelete(@RequestParam Integer noticeId) {
		int n = noticeService.noticeDelete(noticeId);
		System.out.println(n);
		return "redirect:/notice";
	}
}
