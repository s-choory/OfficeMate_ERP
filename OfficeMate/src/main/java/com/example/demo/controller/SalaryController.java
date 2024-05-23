package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
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

import com.example.demo.dto.MonthSalaryDTO;
import com.example.demo.service.MonthSalaryService;
import com.example.demo.service.UserService;

@Controller
public class SalaryController {
	
	@Autowired
	MonthSalaryService monthSalaryService;
	@Autowired
	UserService userService;

	@GetMapping("/salary")
	public String salary() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if (name.equals("admin")) {
			return "redirect:/admin/salary";
		}
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
	    
	    String paymentDescription = currentMonth.toString().substring(6,7) + "월급여대장";
	    BigDecimal totalAmount = calculateTotalAmount();

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
		return "salary/salary_ledger";
	}

    private BigDecimal calculateTotalAmount() {
        BigDecimal result = userService.getUserTotalAmount();
        return result;
    }
    
    

}
