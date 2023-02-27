package com.koreaIT.java.BAM.dto;

public class Article extends Dto {

	public int look;
	public String title;
	public String body;
	public int memberId;

	public Article(int id, String regDate, int memberId, String title, String body) {
		this(id, regDate, memberId, title, body, 0);
	}

	public Article(int id, String regDate, int memberId, String title, String body, int look) {
		this.id = id;
		this.regDate = regDate;
		this.memberId = memberId;

		this.title = title;
		this.body = body;
		this.look = look;

	}

	public void addLook() {
		look++;

	}

}
