package com.kh.home.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberPhone;
	private Date memberJoin;
	private String memberEmail;
	private int memberPoint;
	private String memberGrade;
	
	
	
}
