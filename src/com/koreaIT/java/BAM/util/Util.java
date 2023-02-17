package com.koreaIT.java.BAM.util;

import java.time.LocalDateTime;

public class Util {
	public static String getDate() {

		LocalDateTime Today = LocalDateTime.now();
		int year = Today.getYear(); // 연도
		int monthValue = Today.getMonthValue();
		int dayOfMonth = Today.getDayOfMonth(); // 일(월 기준)
		int hour = Today.getHour();
		int minute = Today.getMinute();
		int second = Today.getSecond();
		String now = "" + year + "-" + monthValue + "-" + dayOfMonth + " " + hour + ":" + minute + ":" + second;

		return now;
	}

}
