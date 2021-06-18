package com.kh.home;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.home.entity.ItemDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
public class TestMybatis {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		String itemName="피자10판";
		List<ItemDto> list = sqlSession.selectList("item.select2",itemName);
		for(ItemDto itemDto : list) {
			System.out.println(itemDto);
		}
	}
	
}
