package com.koreaIT.java.BAM.Dao;

import java.util.ArrayList;
import java.util.List;

import com.koreaIT.java.BAM.dto.Article;

public class ArticleDao extends Dao {

	public List<Article> articles;

	public ArticleDao() {
		this.articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId++;
	}
	public void remove(int idx) {
		articles.remove(idx);
		
	}

	public List<Article> getPrintArticles(String searchKeyword) {

		if (searchKeyword != null) {

			List<Article> printArticles = new ArrayList<>();

			for (Article article : articles) {
				if (article.title.contains(searchKeyword)) {
					printArticles.add(article);
				}
			}

			return printArticles;

		}
		return articles;
	}

	public Article getArticleById(int id) {

		for (Article article : articles) {

			if (article.id == id) {
				return article;
			}
		}

		return null;
	}
}
