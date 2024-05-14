package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;



@Controller
public class AdminController {
	
	@Autowired
	UserService userService;
	
    @GetMapping("/admin")
    public String admin() {
    	return "admin/admin";
    }
    
    @GetMapping("/emp_manage")
    public String commute(Model model) {
    	List<UserDTO> userList = userService.getUserAll();
    	model.addAttribute("userList",userList);
        return "admin/emp_manage"; 
    }
   

}
