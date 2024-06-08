package com.example.demo.dto;

import java.time.LocalDateTime;

public class ApprovalDTO {
 
	private int approvalId;
    private String title;
    private String creator;
    private String department;
    private String content;
    private String remarks;
    private String attachments;
    private LocalDateTime createdAt;
    private String status;
    private LocalDateTime managerApproval;
    private LocalDateTime departmentHeadApproval;
    private LocalDateTime ceoApproval;
    
	public int getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public ApprovalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getManagerApproval() {
		return managerApproval;
	}
	public void setManagerApproval(LocalDateTime managerApproval) {
		this.managerApproval = managerApproval;
	}
	public LocalDateTime getDepartmentHeadApproval() {
		return departmentHeadApproval;
	}
	public void setDepartmentHeadApproval(LocalDateTime departmentHeadApproval) {
		this.departmentHeadApproval = departmentHeadApproval;
	}
	public LocalDateTime getCeoApproval() {
		return ceoApproval;
	}
	public void setCeoApproval(LocalDateTime ceoApproval) {
		this.ceoApproval = ceoApproval;
	}
	public ApprovalDTO(int approvalId, String title, String creator, String department, String content, String remarks,
			String attachments, LocalDateTime createdAt, String status, LocalDateTime managerApproval,
			LocalDateTime departmentHeadApproval, LocalDateTime ceoApproval) {
		super();
		this.approvalId = approvalId;
		this.title = title;
		this.creator = creator;
		this.department = department;
		this.content = content;
		this.remarks = remarks;
		this.attachments = attachments;
		this.createdAt = createdAt;
		this.status = status;
		this.managerApproval = managerApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.ceoApproval = ceoApproval;
	}
	@Override
	public String toString() {
		return "ApprovalDTO [approvalId=" + approvalId + ", title=" + title + ", creator=" + creator + ", department="
				+ department + ", content=" + content + ", remarks=" + remarks + ", attachments=" + attachments
				+ ", createdAt=" + createdAt + ", status=" + status + ", managerApproval=" + managerApproval
				+ ", departmentHeadApproval=" + departmentHeadApproval + ", ceoApproval=" + ceoApproval + "]";
	}

    
}
