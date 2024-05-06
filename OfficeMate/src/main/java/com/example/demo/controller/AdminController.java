package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AdminController {
	
	
    @GetMapping("/admin")
    public String admin() {
    	return "admin/admin";
    }
    
    @GetMapping("/emp_manage")
    public String commute() {
        return "admin/emp_manage"; 
    }

}
