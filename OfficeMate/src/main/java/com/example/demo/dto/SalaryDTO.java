package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalaryDTO {
    private int salaryId;
    private int userId;
    private LocalDate salaryDate;
    private BigDecimal amount;
    private String paymentMethod;
    private String description;
    private int bonus;

    @Override
	public String toString() {
		return "SalaryDTO [salaryId=" + salaryId + ", userId=" + userId + ", salaryDate=" + salaryDate + ", amount="
				+ amount + ", paymentMethod=" + paymentMethod + ", description=" + description + ", bonus="+bonus+"]";
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public SalaryDTO(int userId, LocalDate salaryDate,BigDecimal amount, String paymentMethod,
			String description) {
		super();
		this.userId = userId;
		this.salaryDate = salaryDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.description = description;
	}

	// 기본 생성자
    public SalaryDTO() {}

	public int getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getSalaryDate() {
		return salaryDate;
	}

	public void setSalaryDate(LocalDate salaryDate) {
		this.salaryDate = salaryDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    
}
