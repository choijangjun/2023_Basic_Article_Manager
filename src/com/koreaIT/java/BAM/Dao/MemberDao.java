package com.koreaIT.java.BAM.Dao;

import java.util.ArrayList;
import java.util.List;

import com.koreaIT.java.BAM.dto.Member;

public class MemberDao {
	public List<Member> members;

	public MemberDao() {
		this.members = new ArrayList<>();
	}

}
