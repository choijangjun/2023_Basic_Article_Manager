package com.koreaIT.java.BAM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.dto.Article;
import com.koreaIT.java.BAM.util.Util;

public class App {
	private List<Article> articles;

	App() {
		articles = new ArrayList<>();
	}

	int lastArticleId = 0;
	int id = 0;
	int look;

	public void run() {
		System.out.println("== 프로그램 시작==");

		Scanner sc = new Scanner(System.in);

		makeTestData();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
			
			if (cmd.equals("member join")) {
				System.out.printf("로그인 아이디 :");
				String LoginId = sc.nextLine();
				System.out.printf("로그인 비밀번호 :");
				String LoginPw = sc.nextLine();
				System.out.printf("로그인 비밀번호 확인 :");
				String reLoginPw = sc.nextLine();
				System.out.printf("이름 :");
				String name = sc.nextLine();
				
				System.out.println();
			}

			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			if (cmd.equals("exit")) {
				break;

			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");

				} else {
					System.out.println("번호	|	제목	|	 날짜	 |	조회수");
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);

						System.out.printf("%d	|	%s	|	%s	|	%d\n", article.id, article.title,
								article.now.substring(0, 9), article.look);
					}

				}

			} else if (cmd.equals("article write")) {
				id = lastArticleId + 1;
				lastArticleId = id;
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				String now = Util.getDate();
				int look = 0;

				Article article = new Article(id, now, look, title, body);

				articles.add(article);

//				System.out.printf("제목 : %s \n내용 : %s\n",title,body);
				System.out.printf("%d번 글이 생성되었습니다.\n", id);

			} else if (cmd.startsWith("article list")) {

				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;

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
						System.out.println("검색결과가 없습니다.");
						continue;
					}

				}

				System.out.println("번호	|	제목	|	 날짜	 |	조회수");
				Collections.reverse(printArticles);
				for (int i = printArticles.size() - 1; i >= 0; i--) {
					Article article = printArticles.get(i);
					System.out.printf("%d	|	%s	|	%s	|	%d\n", article.id, article.title,
							article.now.substring(0, 9), article.look);

				}

			} else if (cmd.startsWith("article detail ")) {

				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				foundArticle.addLook();
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : %s\n", foundArticle.now);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);
				System.out.printf("조회수 : %d\n", foundArticle.look);

			} else if (cmd.startsWith("article modify ")) {

				String[] cmdBits = cmd.split(" ");
				String t = cmdBits[2];

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine();

				foundArticle.title = title;
				foundArticle.body = body;

				String now = Util.getDate();
				String nowTime = now;
				now = nowTime;

				System.out.printf("%d번 게시물이 수정되었습니다.\n", id);

			} else if (cmd.startsWith("article delete ")) {

				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}

				int idx = articles.indexOf(foundArticle);
//				System.out.println(idx);
				articles.remove(idx);

				System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);

			} else {
				System.out.println("존재하지 않는 명령어 입니다. ");

			}

		}

		System.out.println("== 프로그램 끝==");

		sc.close();

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

	private Article getArticleByTitle(String t) {
		for (Article article : articles) {

			if (article.title == t) {
				return article;
			}
		}

		return null;
	}

	private void makeTestData() {

		for (int i = 1; i <= 3; i++) {
			id = lastArticleId + 1;
			lastArticleId = id;

			String title = "title" + id;

			String body = "body" + id;

			String now = Util.getDate();

			look = id * 10;

			Article article = new Article(id, now, look, title, body);

			articles.add(article);
			System.out.printf("%d번 글이 생성되었습니다.\n", id);

		}

	}

}
