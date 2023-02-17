package com.koreaIT.java.BAM.dto;

public class Article {
	public int id;
	public String now;
	public int look;
	public String title;
	public String body;

	public Article(int id, String now, int look, String title, String body) {
		this.id = id;
		this.now = now;
		this.look = look;
		this.title = title;
		this.body = body;
	}

	public void addLook() {
		look++;

	}

}
