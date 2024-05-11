package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.DeptService;



@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
    @GetMapping("/dept")
    public String dept(Model model) {
    	
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	if(name.equals("admin")) {
    		return "redirect:/admin/dept";
    	}else {
    		UserDTO userDTO = deptService.findByUsername(name);
    		return "redirect:/deptDetail?departmentId="+userDTO.getDepartmentId();
    	}
    	
    }
    @GetMapping("/admin/dept")
    public String adminDept(Model model) {
    	List<DeptDTO> deptList = deptService.getDeptAll();
    	model.addAttribute("deptList", deptList);
        return "dept/dept"; 
    }

    
    @GetMapping("/deptDetail")
    public String deptDetail(@RequestParam int departmentId, Model model) {
    	List<UserDTO> userList = deptService.getDeptUser(departmentId);
    	DeptDTO deptDTO = deptService.getDeptOne(departmentId);
    	model.addAttribute("userList", userList);
    	model.addAttribute("deptDTO", deptDTO);
    	return "dept/dept_detail";
    }
}
