package com.example.demo.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DeptService deptService;

	
	@GetMapping("userDetailDefault")
	public String userDetailDefault(Model model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO user = userService.getUserByName(name);
		List<DeptDTO> deptList = deptService.getDeptAll();
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		if (user.getDepartmentId() != 0) {
			DeptDTO deptDTO = deptService.getDeptOne(user.getDepartmentId());
			model.addAttribute("deptOne", deptDTO);
		}
		byte[] fileBytes = user.getUserImg();
		if (fileBytes != null && fileBytes.length > 0) {
			String base64EncodedImage = Base64.getEncoder().encodeToString(fileBytes);
			model.addAttribute("base64EncodedFile", base64EncodedImage);

		}

		return "user/user_detail_default";
	}


}
