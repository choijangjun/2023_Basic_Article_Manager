package com.koreaIT.java.BAM.service;

import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dto.Member;

public class MemberService {

	public  boolean loginIdDupChk(String loginId) {
		return Container.memberDao.loginIdDupChk(loginId);
	}

	public String getWriterName(int memberId) {
		// TODO Auto-generated method stub
		return Container.memberDao.getWriterName(memberId);
	}

	public Member getMemberByLoginId(String loginId) {
		return Container.memberDao.getMemberByLoginId(loginId);
	}

	public int getLastId() {
		return Container.memberDao.getLastId();
	}
	public void add(Member member) {
		Container.memberDao.add(member);
	}

}
