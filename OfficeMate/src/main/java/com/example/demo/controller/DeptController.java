package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @PostMapping("/deptAdd")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deptAdd(@RequestParam String departmentName) {
    	int n = deptService.insertDept(departmentName);
    	DeptDTO dept = deptService.getDeptOneName(departmentName);
        Map<String, Object> response = new HashMap<>();

        if (n != 0 && dept != null) {
            response.put("status", "success");
            response.put("message", "부서 추가가 완료되었습니다.");
            response.put("department", dept); // 새로 추가된 부서 정보 포함
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "부서 추가에 실패하였습니다.");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @PostMapping("/deptUpdate")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deptUpdate(@RequestParam int departmentId, @RequestParam String departmentName) {
    	int n = deptService.updateDept(departmentId, departmentName);
        DeptDTO updatedDept = deptService.getDeptOneName(departmentName);
        Map<String, Object> response = new HashMap<>();

        if (n != 0 && updatedDept != null) {
            response.put("status", "success");
            response.put("message", "부서 수정이 완료되었습니다.");
            response.put("department", updatedDept);
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "부서 수정에 실패하였습니다.");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    @GetMapping("/admin/deptDelete")
    public String deptDelete(@RequestParam int departmentId) {
    	int n = deptService.deptDelete(departmentId);
    	System.out.println(n);
    	return "redirect:/admin/dept";
	}

}
