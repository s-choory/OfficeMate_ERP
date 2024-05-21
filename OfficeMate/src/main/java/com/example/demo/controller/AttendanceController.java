package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.AttendanceDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.AttendanceService;
import com.example.demo.service.UserService;

@Controller
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	UserService userService;

	@GetMapping("/attendance")
	public String commute(Model model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		if(name.equals("admin")) {
			return "redirect:/admin/attendance";
		}
		return "attendance/attendance";
	}	

	@GetMapping("/home")
	public String home(Model model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	UserDTO userDTO = userService.getUserByName(name);
    	
    	// 사용자의 오늘 출근 기록 가져오기
    	AttendanceDTO attendanceDTO = attendanceService.getTodayAttendanceByUserId(userDTO.getUserId());
    	
        model.addAttribute("attendanceDTO", attendanceDTO != null ? attendanceDTO : new AttendanceDTO());
    	
		return "home/home";
	}
	
    @PostMapping("/attendance/checkIn")
    @ResponseBody
    public String checkIn(@RequestBody String checkInTime) {

		String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	UserDTO userDTO = userService.getUserByName(name);
    	
    	AttendanceDTO attendanceDTO = new AttendanceDTO(0, userDTO.getUserId(), checkInTime, null, null);
    	if(attendanceService.getTodayAttendanceByUserId(userDTO.getUserId()) == null) {    		
    		int n = attendanceService.checkIn(attendanceDTO);
    	}else {
    		return "이미 출첵 했습니다.";
    	}

        return "출근 시간이 기록되었습니다.";
    }
    
    @PostMapping("/attendance/checkOut")
    @ResponseBody
    public String checkOut(@RequestBody String checkOutTime) {
    	
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	UserDTO userDTO = userService.getUserByName(name);
    	
    	AttendanceDTO attendanceDTO = new AttendanceDTO(0, userDTO.getUserId(), null, checkOutTime, null);
    	int n = attendanceService.checkOut(attendanceDTO);
    	System.out.println(n);
    	
    	return "퇴근 시간이 기록되었습니다.";
    }


}
