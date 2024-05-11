package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
    
    
    @GetMapping("admin/userDetail/{userId}")
    public String getUserById(@PathVariable int userId, Model model) {
        
        UserDTO user = userService.getUserById(userId);
        model.addAttribute("user", user);
        
        return "user/userDetail";
    }
    
}
