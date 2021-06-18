package com.kh.home.repository;

import com.kh.home.entity.MemberDto;

public interface MemberDao {

	void insert(MemberDto memberDto);
	MemberDto login(MemberDto memberDto);
	MemberDto get(int memberNo);
	boolean delete(int memberNo);
	boolean changePassword(int memberNo, String curPassword, String newPassword);
	boolean changeInformation(MemberDto memberDto);
}
