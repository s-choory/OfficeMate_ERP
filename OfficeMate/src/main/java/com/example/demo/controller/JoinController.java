package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.JoinDTO;
import com.example.demo.service.JoinService;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
    @GetMapping("/join")
    public String join() {
        return "join"; // join.html 렌더링
    }
    
    @PostMapping("/joinProc")
    public String joinProcess(JoinDTO joinDTO) {
    	System.out.println(joinDTO);
    	
    	joinService.joinProcess(joinDTO);
    	
    	return "redirect:/login";
    }
}
