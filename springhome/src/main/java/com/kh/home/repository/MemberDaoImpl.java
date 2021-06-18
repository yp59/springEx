package com.kh.home.repository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.home.entity.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//목록 조회용 변환 도구
		private RowMapper<MemberDto> mapper = (rs, index) -> {
			MemberDto memberDto = new MemberDto();
			memberDto.setMemberNo(rs.getInt("member_no"));
			memberDto.setMemberId(rs.getString("member_id"));
			memberDto.setMemberPw(rs.getString("member_pw"));
			memberDto.setMemberNick(rs.getString("member_nick"));
			memberDto.setMemberBirth(rs.getString("member_birth"));
			memberDto.setMemberEmail(rs.getString("member_email"));
			memberDto.setMemberPhone(rs.getString("member_phone"));
			memberDto.setMemberPoint(rs.getInt("member_point"));
			memberDto.setMemberJoin(rs.getDate("member_join"));
			memberDto.setMemberGrade(rs.getString("member_grade"));
			return memberDto;
		};
		//단일 조회용 변환 도구
		private ResultSetExtractor<MemberDto> extractor = (rs) -> {
			if(rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMemberNo(rs.getInt("member_no"));
				memberDto.setMemberId(rs.getString("member_id"));
				memberDto.setMemberPw(rs.getString("member_pw"));
				memberDto.setMemberNick(rs.getString("member_nick"));
				memberDto.setMemberBirth(rs.getString("member_birth"));
				memberDto.setMemberEmail(rs.getString("member_email"));
				memberDto.setMemberPhone(rs.getString("member_phone"));
				memberDto.setMemberPoint(rs.getInt("member_point"));
				memberDto.setMemberJoin(rs.getDate("member_join"));
				memberDto.setMemberGrade(rs.getString("member_grade"));
				return memberDto;
			}
			else {
				return null;
			}
		};
	
	@Override
	public void insert(MemberDto memberDto) {
		String sql = "insert into member values("
				+ " member_seq.nextval,?,?,?,?,?,sysdate,?,0,'일반')";
		Object[] param = {
		/*아이디*/memberDto.getMemberId(),
		/*비밀번*/memberDto.getMemberPw(),
		/*닉네임*/memberDto.getMemberNick(),
		/*내생일*/memberDto.getMemberBirth(),
		/*전화번*/memberDto.getMemberPhone(),
		/*이메일*/memberDto.getMemberEmail()
				
		};
		
		jdbcTemplate.update(sql,param);
		
	}
	
	@Override
	public MemberDto login(MemberDto memberDto) {
		String sql = "select * from member where member_id = ? and member_pw = ?";
		Object[] param = {memberDto.getMemberId(), memberDto.getMemberPw()};
		return jdbcTemplate.query(sql, extractor, param);
	}
	
	@Override
	public MemberDto get(int memberNo) {
		String sql = "select * from member where member_no = ?";
		Object[] param = {memberNo};
		//MemberDto memberDto = jdbcTemplate.query(sql, extractor, memberNo);
		MemberDto memberDto = jdbcTemplate.query(sql, extractor, param);
		return memberDto;
	}
	@Override
	public boolean delete(int memberNo) {
		String sql = "delete member where member_no = ?";
		Object[] param = {memberNo};
		int count = jdbcTemplate.update(sql, param);
		return count > 0;
	}
	
	
	@Override
	public boolean changePassword(int memberNo, String curPassword, String newPassword) {
		String sql = "update member "
						+ "set member_pw = ? "
						+ "where member_no = ? and member_pw = ?";
		Object[] param = {newPassword, memberNo, curPassword};
		int count = jdbcTemplate.update(sql, param);
		return count > 0;
	}
	
	@Override
	public boolean changeInformation(MemberDto memberDto) {
		String sql = "update member "
				+ "set member_nick=?, member_birth=?, member_phone=?, member_email=? "
				+ "where member_no=? and member_pw=?";
		Object[] param = {
			memberDto.getMemberNick(),
			memberDto.getMemberBirth(),
			memberDto.getMemberPhone(),
			memberDto.getMemberEmail(),
			memberDto.getMemberNo(),
			memberDto.getMemberPw()
		};
		int count = jdbcTemplate.update(sql, param);
		return count > 0;
	}
}
