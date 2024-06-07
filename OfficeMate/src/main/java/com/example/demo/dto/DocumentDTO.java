package com.example.demo.dto;

import java.util.Arrays;

public class DocumentDTO {

	private int documentId;
	private String documentName;
	private String description;
	private int uploadedBy;
	private String uploadUser;
	private String uploadDate;
	private byte[] files;
	private String fileName;
	private String shareUser;
	private String updateDate;
    private int version;
    private int previousVersionId;
	
	public DocumentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "DocumentDTO [documentId=" + documentId + ", documentName=" + documentName + ", description="
				+ description + ", uploadedBy=" + uploadedBy + ", uploadUser=" + uploadUser + ", uploadDate="
				+ uploadDate + ", files=" + Arrays.toString(files) + ", fileName=" + fileName + ", shareUser="
				+ shareUser + ", updateDate=" + updateDate + ", version=" + version + ", previousVersionId="
				+ previousVersionId + "]";
	}



	public DocumentDTO(int documentId, String documentName, String description, int uploadedBy, String uploadUser,
			String uploadDate, byte[] files, String fileName, String shareUser, String updateDate, int version,
			int previousVersionId) {
		super();
		this.documentId = documentId;
		this.documentName = documentName;
		this.description = description;
		this.uploadedBy = uploadedBy;
		this.uploadUser = uploadUser;
		this.uploadDate = uploadDate;
		this.files = files;
		this.fileName = fileName;
		this.shareUser = shareUser;
		this.updateDate = updateDate;
		this.version = version;
		this.previousVersionId = previousVersionId;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public int getPreviousVersionId() {
		return previousVersionId;
	}



	public void setPreviousVersionId(int previouseVersionId) {
		this.previousVersionId = previouseVersionId;
	}



	public String getUploadUser() {
		return uploadUser;
	}
	
	public String getShareUser() {
		return shareUser;
	}

	public void setShareUser(String shareUser) {
		this.shareUser = shareUser;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFiles() {
		return files;
	}

	public void setFiles(byte[] files) {
		this.files = files;
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
