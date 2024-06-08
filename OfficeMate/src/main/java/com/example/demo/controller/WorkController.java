package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.WorkDTO;
import com.example.demo.service.DeptService;
import com.example.demo.service.UserService;
import com.example.demo.service.WorkService;

@Controller
public class WorkController {

	@Autowired
	WorkService workService;
	@Autowired
	UserService userService;
	@Autowired
	DeptService deptService;

	@GetMapping("/work")
	public String work(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (username.equals("admin")) {
			return "redirect:/admin/work";
		} else {
			UserDTO userDTO = userService.getUserByName(username);
			PageDTO pageDTO = null;
			List<WorkDTO> workList = new ArrayList<>();
			if (!("없음").equals(userDTO.getUserPosition())){
				pageDTO = new PageDTO(workService.workGetDeptCount(userDTO.getDepartmentId()), page);
				workList = workService.getListDeptPage(pageDTO, userDTO.getDepartmentId());
			} else {
				pageDTO = new PageDTO(workService.workGetCount(userDTO.getUserId()), page);
				workList = workService.getListUserPage(pageDTO, userDTO.getUserId());
			}
			List<UserDTO> userList = userService.getUserAll();
			model.addAttribute("workList", workList);
			model.addAttribute("page", page);
			model.addAttribute("pageDTO", pageDTO);
			model.addAttribute("userDTO", userDTO);
			model.addAttribute("userList", userList);
			return "work/work_user";
		}
	}

	@GetMapping("/workConfirm")
	public String workConfirm(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO userDTO = userService.getUserByName(username);
		PageDTO pageDTO = null;
		List<WorkDTO> workList = new ArrayList<>();
		if (!("없음").equals(userDTO.getUserPosition())){
			pageDTO = new PageDTO(workService.workConfirmDeptCount(userDTO.getDepartmentId()), page);
			workList = workService.getListConfirmDeptPage(pageDTO, userDTO.getDepartmentId());
		} else {
			pageDTO = new PageDTO(workService.workConfirmGetCount(userDTO.getUserId()), page);
			workList = workService.getListConfirmUserPage(pageDTO, userDTO.getUserId());
		}
		List<UserDTO> userList = userService.getUserAll();
		model.addAttribute("workList", workList);
		model.addAttribute("page", page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("userList", userList);
		return "work/workConfirm_user";
	}

	@GetMapping("/admin/work")
	public String workuser(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		PageDTO pageDTO = new PageDTO(workService.workAllCount(), page);
		List<WorkDTO> workList = workService.getListWorkAll(pageDTO);
		List<UserDTO> userList = userService.getUserAll();
		List<DeptDTO> deptList = deptService.getDeptAll();
		model.addAttribute("workList", workList);
		model.addAttribute("page", page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("userList", userList);
		model.addAttribute("deptList", deptList);
		return "work/work_admin";
	}

	@GetMapping("/admin/workConfirm")
	public String workAdminConfirm(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		PageDTO pageDTO = new PageDTO(workService.workAllCountConfirm(), page);
		List<WorkDTO> workList = workService.getListWorkAllConfirm(pageDTO);
		List<UserDTO> userList = userService.getUserAll();
		List<DeptDTO> deptList = deptService.getDeptAll();
		model.addAttribute("workList", workList);
		model.addAttribute("page", page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("userList", userList);
		model.addAttribute("deptList", deptList);
		return "work/workConfirm_admin";
	}

	@GetMapping("/workAdd")
	public String workAdd() {
		return "work/work_user_add";
	}

	@PostMapping("/workAddConfirm")
	public String workAddConfirm(WorkDTO workDTO) {
		System.out.println(workDTO);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO userDTO = userService.getUserByName(username);
		if (userDTO != null) {
			workDTO.setAssignedTo(userDTO.getUserId());
			workDTO.setDepartmentsId(userDTO.getDepartmentId());
		}
		int n = workService.workAdd(workDTO);
		System.out.println(n);
		return "redirect:/work";
	}

	@PostMapping("/updateWorkStatus")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> updateWorkStatus(@RequestParam int workId,
			@RequestParam("status") String status) {

		int n = workService.updateStatus(workId, status);

		Map<String, Object> response = new HashMap<>();

		if (n != 0) {
			response.put("status", "success");
			response.put("workId", workId);
			response.put("st", status);
			return ResponseEntity.ok(response);
		} else {
			response.put("status", "error");
			response.put("message", "부서 수정에 실패하였습니다.");
			return ResponseEntity.badRequest().body(response);
		}
	}

	@PostMapping("/deleteWork")
	@ResponseBody
	public ResponseEntity<String> deleteWork(@RequestParam int workId) {
		try {
			workService.deleteWork(workId);
			return ResponseEntity.ok("success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("error");
		}
	}

	@PostMapping("/updateWorkDescription")
	@ResponseBody
	public Map<String, String> updateWorkDescription(@RequestParam int workId,
			@RequestBody Map<String, String> payload) {
		String newDescription = payload.get("description");

		try {
			workService.updateWorkDescription(workId, newDescription);
			return Collections.singletonMap("status", "success");
		} catch (Exception e) {
			return Collections.singletonMap("status", "error");
		}
	}

	@GetMapping("/work/{workId}")
	public String noticeContent(@PathVariable Integer workId, Model model) {
		WorkDTO workDTO = workService.getWorkOne(workId);
		UserDTO userDTO = userService.getUserById(workDTO.getAssignedTo());
		model.addAttribute("work", workDTO);
		model.addAttribute("user", userDTO);
		return "work/work_content";
	}

}
