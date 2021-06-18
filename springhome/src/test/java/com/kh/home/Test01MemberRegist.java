package com.kh.home;
//테스트 목적
//=Spring JDBC를 이용해서 회원 가입을 구현하는 것!

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class Test01MemberRegist {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		String sql = "insert into member values("
				+ " member_seq.nextval,?,?,?,?,?,sysdate,?,0,'일반')";
		Object[] param = {
		/*아이디*/"tdd143456",
		/*비밀번*/"tdd143456",
		/*닉네임*/"티디디닉",
		/*내생일*/"1999-12-15",
		/*전화번*/"010-4347-4444",
		/*이메일*/"hang11e@kh.com"
				
		};
		
		jdbcTemplate.update(sql,param);
		
	}
}
