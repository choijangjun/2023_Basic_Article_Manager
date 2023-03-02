package com.koreaIT.java.BAM.Dao;

import java.util.ArrayList;



import java.util.List;

import com.koreaIT.java.BAM.dto.Member;

public class MemberDao extends Dao {
	public List<Member> members;

	public MemberDao() {
		this.members = new ArrayList<>();
		
	}
	public void add(Member member) {
		members.add(member);
		lastId++;
	}
	public Member getMemberByLoginId(String loginId) {

		for (Member member : members) {
			if (member.loginId.equals(loginId)) {

				return member;
			}
		}

		return null;
	}
	public boolean loginIdDupChk(String loginId) {

		Member member = getMemberByLoginId(loginId);

		if (member != null) {
			return false;
		}

		return true;
	}
	public String getWriterName(int memberId) {

		for (Member member : members) {
			if (memberId == member.id) {
			
				return member.name;
			}
		}
		return null;
	}


}
