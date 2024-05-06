package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class DeptController {
	
    @GetMapping("/dept")
    public String dept() {
        return "dept/dept"; 
    }

}
