package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	DeptService deptService;

	@GetMapping("/admin")
	public String admin() {
		return "admin/admin";
	}

	@GetMapping("/admin/empManage")
	public String commute(Model model) {
		List<UserDTO> userList = userService.getUserAll();
		List<DeptDTO> deptList = deptService.getDeptAll();
		model.addAttribute("userList", userList);
		model.addAttribute("deptList", deptList);
		return "admin/emp_manage";
	}

	@GetMapping("/admin/userDetail/{userId}")
	public String userDetail(Model model, @PathVariable int userId) {
		UserDTO userDTO = userService.getUserById(userId);
		List<DeptDTO> deptList = deptService.getDeptAll();
		model.addAttribute("user", userDTO);
		model.addAttribute("deptList", deptList);
		
		byte[] fileBytes = userDTO.getUserImg();
		if (fileBytes != null && fileBytes.length > 0) {
			String base64EncodedImage = Base64.getEncoder().encodeToString(fileBytes);
			model.addAttribute("base64EncodedFile", base64EncodedImage);

		}
		
		if (userDTO.getDepartmentId() != 0) {
			DeptDTO deptDTO = deptService.getDeptOne(userDTO.getDepartmentId());
			model.addAttribute("deptOne", deptDTO);
		}
		return "user/user_detail";
	}

	@PostMapping("/admin/userDetailUpdate")
	public String userDetailUpdate(UserDTO userDTO) {
		int n = userService.updateUserDetail(userDTO);
		System.out.println(n);
		return "redirect:/admin/empManage";
	}

	@PostMapping("/admin/userDelete")
	public String userDelete(UserDTO userDTO) {
		int n = userService.deleteUser(userDTO.getUserId());
		System.out.println(n);
		return "redirect:/admin/empManage";
	}
	
	@PostMapping("/admin/uploadImage")
	public String uploadImage(@RequestParam("userImg") MultipartFile file, @RequestParam("userId") int userId) throws IOException {
		
		userService.updateUserImg(userId, file.getBytes());
	    
	    return "redirect:/admin/userDetail/"+userId;
	}


}
