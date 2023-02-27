package com.koreaIT.java.BAM.Dao;

import java.util.ArrayList;
import java.util.List;

import com.koreaIT.java.BAM.dto.Article;

public class ArticleDao {
	public List<Article> articles;

	public ArticleDao() {
		this.articles = new ArrayList<>();
	}

}
