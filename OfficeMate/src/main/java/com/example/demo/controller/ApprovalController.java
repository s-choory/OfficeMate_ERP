package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.ApprovalDTO;
import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.DocumentDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.ApprovalService;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;

@Controller
public class ApprovalController {

	@Autowired
	ApprovalService approvalService;
	@Autowired
	UserService userService;
	@Autowired
	DeptService deptService;

	@GetMapping("/approval")
	public String approval(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO user = userService.getUserByName(name);		
		PageDTO pageDTO;
		List<ApprovalDTO> approvalList = new ArrayList<>();
		
		if("admin".equals(name)) {
			pageDTO = new PageDTO(approvalService.approvalGetCountAll(), page);
			approvalList = approvalService.getListAll(pageDTO);
		}else if("없음".equals(user.getUserPosition())) {
			pageDTO = new PageDTO(approvalService.approvalGetCount(name), page);
			approvalList = approvalService.getList(name, pageDTO);
		}else{
			String deptName = deptService.getDeptOne(user.getDepartmentId()).getDepartmentName();
			pageDTO = new PageDTO(approvalService.approvalGetCountDept(deptName), page);
			approvalList = approvalService.getListDept(deptName,pageDTO);
		}
		
		model.addAttribute("approvalList",approvalList);
		model.addAttribute("page", page);
		model.addAttribute("pageDTO", pageDTO);
		return "approval/approval";
	}
	
	@GetMapping("/approvalComplete")
	public String approvalComplete(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO user = userService.getUserByName(name);
		
		PageDTO pageDTO;
		List<ApprovalDTO> approvalList = new ArrayList<>();
		
		if("admin".equals(name)) {
			pageDTO = new PageDTO(approvalService.approvalGetCountCompleteAll(), page);
			approvalList = approvalService.getListCompleteAll(pageDTO);
		}else if("없음".equals(user.getUserPosition())) {
			pageDTO = new PageDTO(approvalService.approvalGetCountComplete(name), page);
			approvalList = approvalService.getListComplete(name, pageDTO);
		}else{
			String deptName = deptService.getDeptOne(user.getDepartmentId()).getDepartmentName();
			pageDTO = new PageDTO(approvalService.approvalGetCountDeptComplete(deptName), page);
			approvalList = approvalService.getListDeptComplete(deptName,pageDTO);
		}
		
		model.addAttribute("approvalList",approvalList);
		model.addAttribute("page", page);
		model.addAttribute("pageDTO", pageDTO);
		return "approval/approvalComplete";
	}
	
	@GetMapping("/approval/{approvalId}")
	public String documentContent(@PathVariable Integer approvalId, Model model) {
		ApprovalDTO approval =  approvalService.getApprovalOne(approvalId);
		UserDTO userDTO = userService.getUserByName(approval.getCreator());
		List<DeptDTO> deptList = deptService.getDeptAll();
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO currentUser = userService.getUserByName(name);
		model.addAttribute("approval",approval);
		model.addAttribute("user",userDTO);
		model.addAttribute("currentUser",currentUser);
		model.addAttribute("deptList", deptList);
		return "approval/approval_detail";
	}

	
	@GetMapping("/approvalAdd")
	public String approvalAdd(Model model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO user = userService.getUserByName(name);
		List<DeptDTO> deptList = deptService.getDeptAll();
		model.addAttribute("user", user);
		model.addAttribute("deptList", deptList);
		return "approval/approval_add";
	}
	
	@PostMapping("/submitApproval")
	public String submitApproval(ApprovalDTO approvalDTO) {
		int n = approvalService.approvalAdd(approvalDTO);
		System.out.println(n);
		return "redirect:/approval";
	}
	
    @PostMapping("/approve/{position}")
    @ResponseBody
    public ResponseEntity<Void> approve(@PathVariable String position, @RequestBody Map<String, Long> requestBody) {
        Long approvalId = requestBody.get("approvalId");
        
        try {
            switch (position) {
                case "manager":
                    approvalService.approveManager(approvalId);
                    break;
                case "departmentHead":
                    approvalService.approveDepartmentHead(approvalId);
                    break;
                case "ceo":
                    approvalService.approveCeo(approvalId);
                    break;
                default:
                    return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
