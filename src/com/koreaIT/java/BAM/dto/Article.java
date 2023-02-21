package com.koreaIT.java.BAM.dto;

public class Article extends Dto {

	public int look;
	public String title;
	public String body;

	public Article(int id, String regDate, int look, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.look = look;
		this.title = title;
		this.body = body;
	}

	public void addLook() {
		look++;

	}

}
