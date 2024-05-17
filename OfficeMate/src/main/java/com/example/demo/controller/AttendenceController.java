package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendenceController {

	@GetMapping("/attendence")
	public String commute() {
		return "attendence/attendence";
	}

}
