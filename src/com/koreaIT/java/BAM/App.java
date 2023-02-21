package com.koreaIT.java.BAM;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.java.BAM.controller.ArticleController;
import com.koreaIT.java.BAM.controller.MemberController;
import com.koreaIT.java.BAM.dto.Article;
import com.koreaIT.java.BAM.dto.Member;
import com.koreaIT.java.BAM.util.Util;

public class App {
	private List<Article> articles;
	private List<Member> members;

	App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
		
	}
	int id = 0;
	int look;


	public void run() {
		System.out.println("== 프로그램 시작==");


		makeTestData();

		Scanner sc = new Scanner(System.in);
		
		MemberController memberController = new MemberController(members, sc);
		ArticleController articleController = new ArticleController(articles, sc);
		
		int lastArticleId = 3;
		int lastMemberId= 0;
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");
				continue;
			}
			if (cmd.equals("exit")) {
				break;

			}

			if (cmd.equals("member join")) {
				memberController.doJoin();
			}else if (cmd.equals("article write")) {
				articleController.doWrite();
				

			} else if (cmd.startsWith("article list")) {
				articleController.showList(cmd);
				

				

			} else if (cmd.startsWith("article detail ")) {
				articleController.showDetail(cmd);

				

			} else if (cmd.startsWith("article modify ")) {
				articleController.doModify(cmd);
				

				

			} else if (cmd.startsWith("article delete ")) {
				articleController.doDelete(cmd);

				

			} else {
				System.out.println("존재하지 않는 명령어 입니다. ");

			}

		}

		System.out.println("== 프로그램 끝==");

		sc.close();

	}

	



	private void makeTestData() {
		int lastArticleId = 0;

		for (int i = 1; i <= 3; i++) {
			id = lastArticleId + 1;
			lastArticleId = id;

			String title = "title" + id;

			String body = "body" + id;

			String regDate = Util.getDate();

			look = id * 10;

			Article article = new Article(id, regDate, look, title, body);

			articles.add(article);

		}
		System.out.printf("3개의 테스트 데이터를 생성하였습니다.\n");

	}

}
