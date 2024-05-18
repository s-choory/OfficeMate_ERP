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
		}else {
			UserDTO userDTO = userService.getUserByName(username);
			PageDTO pageDTO = new PageDTO(workService.workGetCount(userDTO.getUserId()), page);
			List<WorkDTO> workList = workService.getListUserPage(pageDTO, userDTO.getUserId());
			model.addAttribute("workList", workList);
			model.addAttribute("page", page);
			model.addAttribute("pageDTO", pageDTO);
			return "work/work_user";
		}
	}
	
	@GetMapping("/workConfirm")
	public String workConfirm(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO userDTO = userService.getUserByName(username);
		PageDTO pageDTO = new PageDTO(workService.workConfirmGetCount(userDTO.getUserId()), page);
		List<WorkDTO> workList = workService.getListConfirmUserPage(pageDTO, userDTO.getUserId());
		model.addAttribute("workList", workList);
		model.addAttribute("page", page);
		model.addAttribute("pageDTO", pageDTO);
		return "work/workConfirm_user";
	}

	@GetMapping("/admin/work")
	public String workuser() {
//		DeptDTO deptDTO = deptService.getDeptOne(workList.get(0).getDepartmentsId());
//		model.addAttribute("departmentName",deptDTO.getDepartmentName());
		return "work/work_admin";
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
    public ResponseEntity<Map<String, Object>> updateWorkStatus(@RequestParam int workId, @RequestParam("status") String status) {
    	
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
    
   
    

}
