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
    
    @GetMapping("/users")
    public String getUsersPage() {
        return "users";
    }
    
    @GetMapping("/users/{userId}")
    public String getUserById(@PathVariable int userId, Model model) {
        // 사용자 정보를 받아오는 로직
        UserDTO user = userService.getUserById(userId);
        model.addAttribute("user", user);
        // 사용자 정보를 HTML 페이지에 전달하여 사용자 정보를 표시
        return "userDetails"; // 사용자 정보를 표시하는 HTML 파일의 경로
    }

    
    // 다른 컨트롤러 메소드들을 여기에 추가할 수 있습니다.
}
