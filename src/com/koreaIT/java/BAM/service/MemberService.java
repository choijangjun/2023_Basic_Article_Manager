package com.koreaIT.java.BAM.service;

import com.koreaIT.java.BAM.Dao.MemberDao;
import com.koreaIT.java.BAM.container.Container;
import com.koreaIT.java.BAM.dto.Member;

public class MemberService {
	private MemberDao memberDao;

	public MemberService() {
		this.memberDao = Container.memberDao;
	}


	public  boolean loginIdDupChk(String loginId) {
		return memberDao.loginIdDupChk(loginId);
	}

	public String getWriterName(int memberId) {
		return memberDao.getWriterName(memberId);
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public int getLastId() {
		return memberDao.getLastId();
	}
	public void add(Member member) {
		memberDao.add(member);
	}

}
