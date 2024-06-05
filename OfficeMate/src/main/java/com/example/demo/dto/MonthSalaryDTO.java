package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthSalaryDTO {

	private int monthSalaryId;
	private LocalDate paymentMonth;
	private String paymentDescription;
	private BigDecimal totalAmount;
	private LocalDateTime createdAt;
	private String paymentState;

	public MonthSalaryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthSalaryDTO(int monthSalaryId, LocalDate paymentMonth, String paymentDescription, BigDecimal totalAmount,
			LocalDateTime createdAt, String paymentState) {
		super();
		this.monthSalaryId = monthSalaryId;
		this.paymentMonth = paymentMonth;
		this.paymentDescription = paymentDescription;
		this.totalAmount = totalAmount;
		this.createdAt = createdAt;
		this.paymentState = paymentState;
	}

	public String getPaymentState() {
		return paymentState;
	}

	@Override
	public String toString() {
		return "MonthSalaryDTO [monthSalaryId=" + monthSalaryId + ", paymentMonth=" + paymentMonth
				+ ", paymentDescription=" + paymentDescription + ", totalAmount=" + totalAmount + ", createdAt="
				+ createdAt + ", paymentState=" + paymentState + "]";
	}

	public void setPaymentState(String paymentState) {
		this.paymentState = paymentState;
	}

	public int getMonthSalaryId() {
		return monthSalaryId;
	}

	public void setMonthSalaryId(int monthSalaryId) {
		this.monthSalaryId = monthSalaryId;
	}

	public LocalDate getPaymentMonth() {
		return paymentMonth;
	}

	public void setPaymentMonth(LocalDate paymentMonth) {
		this.paymentMonth = paymentMonth;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
