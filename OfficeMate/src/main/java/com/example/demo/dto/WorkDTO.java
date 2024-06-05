package com.example.demo.dto;

public class WorkDTO {

	private int workId;
	private String workName;
	private String description;
	private int assignedTo;
	private String dueDate;
	private int departmentsId;
	private String status;

	public WorkDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkDTO(int workId, String workName, String description, int assignedTo, String dueDate, int departmentsId,
			String status) {
		super();
		this.workId = workId;
		this.workName = workName;
		this.description = description;
		this.assignedTo = assignedTo;
		this.dueDate = dueDate;
		this.departmentsId = departmentsId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "WorkDTO [workId=" + workId + ", workName=" + workName + ", description=" + description + ", assignedTo="
				+ assignedTo + ", dueDate=" + dueDate + ", departmentsId=" + departmentsId + ", status=" + status + "]";
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getDepartmentsId() {
		return departmentsId;
	}

	public void setDepartmentsId(int departmentsId) {
		this.departmentsId = departmentsId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
