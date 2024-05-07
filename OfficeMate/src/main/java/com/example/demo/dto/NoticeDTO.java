package com.example.demo.dto;

public class NoticeDTO {
	
	private int noticeId;
	private String title;
	private String content;
	private int postedBy;
	private String postDate;
	private String updateDate;
	
	public NoticeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticeDTO(int noticeId, String title, String content, int postedBy, String postDate, String updateDate) {
		super();
		this.noticeId = noticeId;
		this.title = title;
		this.content = content;
		this.postedBy = postedBy;
		this.postDate = postDate;
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeId=" + noticeId + ", title=" + title + ", content=" + content + ", postedBy="
				+ postedBy + ", postDate=" + postDate + ", updateDate=" + updateDate + "]";
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
