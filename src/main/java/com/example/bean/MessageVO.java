package com.example.bean;

import java.util.Date;

public class MessageVO {
	private int seq_message;
	private String content_message;
	private Date regdate_message;
	private int cnt_message;

	public int getSeq_message() {
		return seq_message;
	}

	public void setSeq_message(int seq_message) {
		this.seq_message = seq_message;
	}

	public String getContent_message() {
		return content_message;
	}

	public void setContent_message(String content_message) {
		this.content_message = content_message;
	}

	public Date getRegdate_message() {
		return regdate_message;
	}

	public void setRegdate_message(Date regdate_message) {
		this.regdate_message = regdate_message;
	}

	public int getCnt_message() {
		return cnt_message;
	}

	public void setCnt_message(int cnt_message) {
		this.cnt_message = cnt_message;
	}
}