package com.koreaIT.java.BAM.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.dto.Article;
import com.koreaIT.java.BAM.dto.Member;
import com.koreaIT.java.BAM.util.Util;

public class ArticleController extends Controller{
	private List<Article> articles;
	private Scanner sc;
	private int lastArticleId;
	private int id;
	String cmd;
	
	public ArticleController(Scanner sc) {
		this.articles = new ArrayList<>();
		this.sc = sc;
		this.lastArticleId = 3;

	}

	public void doAction(String cmd, String methodName) {
		this.cmd = cmd;
		
		switch(methodName) {
		case "write":
			doWrite();
			break;
		case "list":
			showList();
			break;
		case "detail":
			showDetail();
			break;
		case "modify":
			doModify();
			break;
		case "delete":
			doDelete();
			break;	
		default:
			System.out.println("존재하지 않는 명령어입니다.");
			break;
		 
		}
		
		
	}
	
	private void doWrite() {
		int id = lastArticleId + 1;
		lastArticleId = id;
		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		String regDate = Util.getDate();
		int look = 0;

		Article article = new Article(id, regDate, look, title, body);

		articles.add(article);

//		System.out.printf("제목 : %s \n내용 : %s\n",title,body);
		System.out.printf("%d번 글이 생성되었습니다.\n", id);

	}

	private void showList() {
		if (articles.size() == 0) {
			System.out.println("게시글이 없습니다");
			return; // -> 리턴으로 함수를 종료시키되 넘겨주는 값은 없다.
		}

		String searchKeyword = cmd.substring("article list".length()).trim();

		List<Article> printArticles = new ArrayList<>(articles);

		if (searchKeyword.length() > 0) {
			System.out.println("검색어 : " + searchKeyword);

			printArticles.clear();

			for (Article article : articles) {
				if (article.title.contains(searchKeyword)) {
					printArticles.add(article);
				}
			}
			if (printArticles.size() == 0) {
				System.out.println("검색결과가 없습니다");
				return;
			}
		}

		System.out.println("번호	|	제목	|		날짜		|	조회");
		Collections.reverse(printArticles);
		for (Article article : printArticles) {
			System.out.printf("%d	|	%s	|	%s	|	%d\n", article.id, article.title, article.regDate,
					article.look);
		}
	}

	private void showDetail() {
		String[] cmdBits = cmd.split(" ");
		if(cmdBits.length == 2) {
			System.out.println("명령어를 확인해주세요.");
			return;
		}
		int id = Integer.parseInt(cmdBits[2]);

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}
		foundArticle.addLook();
		System.out.printf("번호 : %d\n", foundArticle.id);
		System.out.printf("날짜 : %s\n", foundArticle.regDate);
		System.out.printf("제목 : %s\n", foundArticle.title);
		System.out.printf("내용 : %s\n", foundArticle.body);
		System.out.printf("조회수 : %d\n", foundArticle.look);

	}

	private void doModify() {
		String[] cmdBits = cmd.split(" ");
		if(cmdBits.length == 2) {
			System.out.println("명령어를 확인해주세요.");
			return;
		}
		int id = Integer.parseInt(cmdBits[2]);


		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}
		System.out.printf("수정할 제목 : ");
		String title = sc.nextLine();
		System.out.printf("수정할 내용 : ");
		String body = sc.nextLine();

		foundArticle.title = title;
		foundArticle.body = body;

		String regDate = Util.getDate();
		String nowTime = regDate;
		regDate = nowTime;

		System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
	}

	private void doDelete() {
		String[] cmdBits = cmd.split(" ");
		if(cmdBits.length == 2) {
			System.out.println("명령어를 확인해주세요.");
			return;
		}
		int id = Integer.parseInt(cmdBits[2]);

		Article foundArticle = getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
			return;
		}

		int idx = articles.indexOf(foundArticle);
//		System.out.println(idx);
		articles.remove(idx);

		System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);

		
	}
	private int getArticleIdById(int id) {
		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);

			if (article.id == id) {
				return i;
			}
			i++;
		}

		return -1;
	}

	private Article getArticleById(int id) {
		for (Article article : articles) {

			if (article.id == id) {
				return article;
			}
		}

		return null;
	}
	public void makeTestData() {
		int lastArticleId = 0;

		for (int i = 1; i <= 3; i++) {
			id = lastArticleId + 1;
			lastArticleId = id;

			String title = "title" + id;

			String body = "body" + id;

			String regDate = Util.getDate();

			int look = id * 10;

			Article article = new Article(id, regDate, look, title, body);

			articles.add(article);

		}
		System.out.printf("3개의 테스트 데이터를 생성하였습니다.\n");

	}


	
}
