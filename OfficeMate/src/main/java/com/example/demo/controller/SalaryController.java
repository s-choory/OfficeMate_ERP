package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.DeptDTO;
import com.example.demo.dto.MonthSalaryDTO;
import com.example.demo.dto.SalaryDTO;
import com.example.demo.dto.TotalPay;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.DeptService;
import com.example.demo.service.MonthSalaryService;
import com.example.demo.service.SalaryService;
import com.example.demo.service.UserService;

@Controller
public class SalaryController {

	@Autowired
	MonthSalaryService monthSalaryService;
	@Autowired
	UserService userService;
	@Autowired
	DeptService deptService;
	@Autowired
	SalaryService salaryService;

	@GetMapping("/salary")
	public String salary(Model model) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if (name.equals("admin")) {
			return "redirect:/admin/salary";
		}
		UserDTO userDTO = userService.getUserByName(name);
		List<SalaryDTO> salaryList = salaryService.getSalaryUser(userDTO.getUserId());
		model.addAttribute("salaryList", salaryList);
		return "salary/salary";
	}

	@GetMapping("/admin/salary")
	public String adminSalary(Model model) {
		List<MonthSalaryDTO> monthSalaryList = monthSalaryService.getAllMonthSalary();
		model.addAttribute("monthSalaryList", monthSalaryList);
		return "salary/admin_salary";
	}

	@PostMapping("/admin/addMonthSalary")
	public ResponseEntity<String> addMonthSalary(MonthSalaryDTO monthSalaryDTO) {
		LocalDate currentMonth = LocalDate.now().withDayOfMonth(1);
		Optional<MonthSalaryDTO> existingPayment = monthSalaryService.findByPaymentMonth(currentMonth);
		if (existingPayment.isPresent()) {
			// 이미 존재하는 경우 alert 띄우기
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error=duplicateMonth");

		}

		String paymentDescription = currentMonth.toString().substring(6, 7) + "월급여대장";
		BigDecimal totalAmount = userService.getUserTotalAmount();

		monthSalaryDTO.setPaymentDescription(paymentDescription);
		monthSalaryDTO.setPaymentMonth(currentMonth);
		monthSalaryDTO.setTotalAmount(totalAmount);

		int result = monthSalaryService.addMonthSalary(monthSalaryDTO);
		if (result > 0) {
			return ResponseEntity.ok("success");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error=failed");
		}

	}

	@GetMapping("/admin/salaryLedger")
	public String salaryLedger(Model model, int monthSalaryId) {
		MonthSalaryDTO monthSalaryDTO = monthSalaryService.getMonthSalary(monthSalaryId);
		List<DeptDTO> deptList = deptService.getDeptAll();
		List<SalaryDTO> salaryList = salaryService.getSalary(monthSalaryDTO.getPaymentMonth());
		List<UserDTO> userList = userService.getMonthSalaryUser(salaryList);
		TotalPay totalPay = new TotalPay(salaryList);

		model.addAttribute("monthSalaryDTO", monthSalaryDTO);
		model.addAttribute("userList", userList);
		model.addAttribute("deptList", deptList);
		model.addAttribute("salaryList", salaryList);
		model.addAttribute("totalPay", totalPay);

		return "salary/salary_ledger";
	}

	@GetMapping("/admin/salaryPaymentComplete")
	public String salaryPaymentComplete(LocalDate paymentMonth) {
		MonthSalaryDTO monthSalaryDTO = monthSalaryService.getMonthSalaryDTO(paymentMonth);
		if (monthSalaryDTO.getPaymentState().equals("지급 완료")) {
			return "redirect:/admin/salary";
		}
		String paymentDescription = paymentMonth.toString().substring(6, 7) + "월급여대장";

		monthSalaryService.salaryPaymentComplete(paymentMonth);
		List<UserDTO> userList = userService.getUserAll();
		for (UserDTO user : userList) {
			if (!user.getUsername().equals("admin")) {
				String monthSalaryString = String.valueOf(user.getMonthSalary());
				BigDecimal monthSalary = new BigDecimal(monthSalaryString);
				SalaryDTO salaryDTO = new SalaryDTO(user.getUserId(), monthSalaryDTO.getPaymentMonth(), monthSalary,
						"계좌이체", paymentDescription);
				salaryService.userSalaryPayment(salaryDTO);
			}
		}
		return "redirect:/admin/salary";
	}

	@GetMapping("/statement")
	public String statement(int salaryId, Model model) {
		SalaryDTO salaryDTO = salaryService.getSalaryOne(salaryId);
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		UserDTO userDTO = userService.getUserByName(name);
		DeptDTO deptDTO = deptService.getDeptOne(userDTO.getDepartmentId());

		model.addAttribute("salary", salaryDTO);
		model.addAttribute("user", userDTO);
		model.addAttribute("dept", deptDTO);
		return "salary/statement";
	}

	@GetMapping("/admin/userStatementSearch")
	public String userStatementSearch(@RequestParam LocalDate paymentMonth, Model model) {
		List<Integer> salaryUserIdList = salaryService.getSalaryList(paymentMonth);
		List<UserDTO> userList = userService.getSalaryUser(salaryUserIdList);
		model.addAttribute("userList", userList);
		model.addAttribute("paymentMonth", paymentMonth);
		return "salary/user_state_search";
	}

	@GetMapping("admin/statement")
	public String userStatement(int userId, LocalDate paymentMonth, Model model) {
		UserDTO userDTO = userService.getUserById(userId);
		DeptDTO deptDTO = deptService.getDeptOne(userDTO.getDepartmentId());
		SalaryDTO salaryDTO = salaryService.getSalaryOne(userId, paymentMonth);

		model.addAttribute("salary", salaryDTO);
		model.addAttribute("user", userDTO);
		model.addAttribute("dept", deptDTO);
		return "salary/admin_statement";
	}

	@PostMapping("/payBonus")
	public ResponseEntity<?> payBonus(@RequestBody SalaryDTO salaryDTO) {
		boolean success = salaryService.payBonus(salaryDTO.getSalaryId(), salaryDTO.getBonus());
		if (success) {
			return ResponseEntity.ok().body(Collections.singletonMap("success", true));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Collections.singletonMap("success", false));
		}
	}

}
