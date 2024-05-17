package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkController {

	@GetMapping("/work")
	public String work() {
		return "work/work";
	}

	@GetMapping("/workUser")
	public String workuser() {
		return "work/work_user";
	}

}
