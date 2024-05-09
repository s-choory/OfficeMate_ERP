package com.example.demo.dto;

public class DocumentDTO {

	private int documentId;
	private String documentName;
	private String description;
	private int uploadedBy;
	private String uploadDate;
	public DocumentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DocumentDTO(int documentId, String documentName, String description, int uploadedBy, String uploadDate) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.description = description;
		this.uploadedBy = uploadedBy;
		this.uploadDate = uploadDate;
	}
	@Override
	public String toString() {
		return "DocumentDTO [documentId=" + documentId + ", documentName=" + documentName + ", description="
				+ description + ", uploadedBy=" + uploadedBy + ", uploadDate=" + uploadDate + "]";
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(int uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
}
