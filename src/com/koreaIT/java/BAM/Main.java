package com.koreaIT.java.BAM;
import java.time.LocalDateTime;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Article> articles;
	
	static {
		articles = new ArrayList<>();		
	}
	static int lastArticleId = 0;
	static int id = 0;
	static int look;
	
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작==");

		Scanner sc = new Scanner(System.in);


		makeTestData();

		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

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

						System.out.printf("%d	|	%s	|	%s	|	%d\n", article.id, article.title , article.now.substring(0,9), article.look);
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
				

			}else if (cmd.startsWith("article detail ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				
				
				
				Article foundArticle = null;
				
				
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if(foundArticle == null) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				foundArticle.addLook();
				System.out.printf("번호 : %d\n", foundArticle.id);
				System.out.printf("날짜 : %s\n", foundArticle.now);
				System.out.printf("제목 : %s\n", foundArticle.title);
				System.out.printf("내용 : %s\n", foundArticle.body);
				System.out.printf("조회수 : %d\n", foundArticle.look);
				
				
			}else if(cmd.startsWith("article delete ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				
				int foundIndex = -1;
				
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if (article.id == id) {
						
						foundIndex = i;
						
					
						
						break;
					}
				}
				
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				articles.remove(foundIndex);
				
				System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
				
			}else if(cmd.startsWith("article modify ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = Integer.parseInt(cmdBits[2]);
				
				
				int foundIndex = -1;
				
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					if (article.id == id) {
						
						foundIndex = i;
						System.out.printf("수정할 제목 : ");
						article.title = sc.nextLine();
						System.out.printf("수정할 내용 : ");
						article.body = sc.nextLine();
						String now = Util.getDate();
						String nowTime = now;
						article.now = nowTime;
						
						
						
						
					
						
						break;
					}
				}
				
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
					continue;
				}
				
				
				System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
				
			}else {
				System.out.println("존재하지 않는 명령어 입니다. ");

			}
			
			

		}

		System.out.println("== 프로그램 끝==");

		sc.close();

	}

	private static void makeTestData() {
		
		for (int i = 1; i <=3; i++) {
			id = lastArticleId + 1;
			lastArticleId = id;
			
			
			String title = "Exam_title" + id;
			
			String body = "Exam_body" + id;
			
			
			String now = Util.getDate();
			
			look = id * 10;
			
			Article article = new Article(id, now, look, title, body);
			
			articles.add(article);
			System.out.printf("%d번 글이 생성되었습니다.\n", id);
			
		}


		
		
		
	}
}

class Article {
	int id;
	String now;
	int look;
	String title;
	String body;

	Article(int id, String now, int look, String title, String body) {
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



 