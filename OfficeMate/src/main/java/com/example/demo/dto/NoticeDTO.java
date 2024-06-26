package com.example.demo.dto;

import java.util.Arrays;

public class NoticeDTO {

	private int noticeId;
	private String title;
	private String content;
	private int postedBy;
	private String postDate;
	private String updateDate;
	private byte[] file;

	public NoticeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeId=" + noticeId + ", title=" + title + ", content=" + content + ", postedBy="
				+ postedBy + ", postDate=" + postDate + ", updateDate=" + updateDate + ", file=" + Arrays.toString(file)
				+ "]";
	}

	public NoticeDTO(int noticeId, String title, String content, int postedBy, String postDate, String updateDate,
			byte[] file) {
		super();
		this.noticeId = noticeId;
		this.title = title;
		this.content = content;
		this.postedBy = postedBy;
		this.postDate = postDate;
		this.updateDate = updateDate;
		this.file = file;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(int posteBy) {
		this.postedBy = posteBy;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}
