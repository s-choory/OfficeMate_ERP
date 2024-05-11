package com.example.demo.dto;

public class DeptDTO {
	
	private int departmentId;
	private String departmentName;
	
	public DeptDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeptDTO(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "DeptDTO [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
}
