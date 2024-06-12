package com.example.demo.dto;

import java.util.List;

public class TotalPay {

	double totalBasicPay = 0;
	double totalIncomeTax = 0;
	double totalResidentTax = 0;
	double totalHealthInsurance = 0;
	double totalEmploymentInsurance = 0;
	double totalDeduction = 0;
	double totalActualPay = 0;

	public TotalPay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalPay(List<SalaryDTO> salaryList) {
		for (SalaryDTO salary : salaryList) {
			double basicPay = salary.getAmount().doubleValue();
			double incomeTax = basicPay * 0.03;
			double residentTax = basicPay * 0.003;
			double healthInsurance = basicPay * 0.06;
			double employmentInsurance = basicPay * 0.007;
			double deduction = basicPay * 0.1;
			double actualPay = basicPay * 0.9;

			totalBasicPay += basicPay;
			totalIncomeTax += incomeTax;
			totalResidentTax += residentTax;
			totalHealthInsurance += healthInsurance;
			totalEmploymentInsurance += employmentInsurance;
			totalDeduction += deduction;
			totalActualPay += actualPay;
		}
	}

	public double getTotalBasicPay() {
		return totalBasicPay;
	}

	public void setTotalBasicPay(double totalBasicPay) {
		this.totalBasicPay = totalBasicPay;
	}

	public double getTotalIncomeTax() {
		return totalIncomeTax;
	}

	public void setTotalIncomeTax(double totalIncomeTax) {
		this.totalIncomeTax = totalIncomeTax;
	}

	public double getTotalResidentTax() {
		return totalResidentTax;
	}

	public void setTotalResidentTax(double totalResidentTax) {
		this.totalResidentTax = totalResidentTax;
	}

	public double getTotalHealthInsurance() {
		return totalHealthInsurance;
	}

	public void setTotalHealthInsurance(double totalHealthInsurance) {
		this.totalHealthInsurance = totalHealthInsurance;
	}

	public double getTotalEmploymentInsurance() {
		return totalEmploymentInsurance;
	}

	public void setTotalEmploymentInsurance(double totalEmploymentInsurance) {
		this.totalEmploymentInsurance = totalEmploymentInsurance;
	}

	public double getTotalDeduction() {
		return totalDeduction;
	}

	public void setTotalDeduction(double totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public double getTotalActualPay() {
		return totalActualPay;
	}

	public void setTotalActualPay(double totalActualPay) {
		this.totalActualPay = totalActualPay;
	}

	@Override
	public String toString() {
		return "TotalPay [totalBasicPay=" + totalBasicPay + ", totalIncomeTax=" + totalIncomeTax + ", totalResidentTax="
				+ totalResidentTax + ", totalHealthInsurance=" + totalHealthInsurance + ", totalEmploymentInsurance="
				+ totalEmploymentInsurance + ", totalDeduction=" + totalDeduction + ", totalActualPay=" + totalActualPay
				+ "]";
	}

}
