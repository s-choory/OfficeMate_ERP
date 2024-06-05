package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.JoinDTO;
import com.example.demo.service.JoinService;

@Controller
public class JoinController {

	@Autowired
	private JoinService joinService;

	@GetMapping("/join")
	public String join(Model model) {
		return "home/join"; // join.html 렌더링
	}

	@PostMapping("/joinProc")
	public String joinProcess(JoinDTO joinDTO, Model model) {

		int n = joinService.joinProcess(joinDTO);
		if (n == 0) {
			model.addAttribute("message", "이미 존재하는 username입니다.");
			return "/home/join";
		}

		return "redirect:/admin/empManage";
	}

}
