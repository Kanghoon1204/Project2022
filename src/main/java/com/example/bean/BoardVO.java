package com.example.bean;

import java.util.Date;

public class BoardVO {
	private int seq;
	private String category;
	private String title;
	private String writer;
	private String content;
	private Date regdate;

	private Date modify;
	private int cnt;

	private String anonymous;

	private boolean have_Img;

	private String photo;
	public BoardVO() {
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getModify() {
		return modify;
	}

	public void setModify(Date modify) {
		this.modify = modify;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String input) {
		this.photo = input;
	}

	public boolean getAnonymous() {

		if (anonymous == "true")
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setAnonymous(boolean anonymous) {
			if (anonymous == true)
			{
				this.anonymous = "true";
			}
			else {
				this.anonymous = "false";
			}

	}

	public boolean getHave_Img() {
		if (getPhoto() != null)
		{
			return true;
		}
		else {

			return false;
		}
	}

	public void setHave_Img(boolean have_Img) {

		if (have_Img == false)
		{
			this.have_Img = false;
		}
		else {
			this.have_Img = true;
		}

	}
}
