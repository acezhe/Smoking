package acezhe.zblog;

import acezhe.zblog.entity.UserInfo;
import acezhe.zblog.service.UserInfoDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZblogApplicationTests {
	@Autowired
	private UserInfoDao dao;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testUserInfoDao(){
		UserInfo u = new UserInfo();
		u.setEmail("asdf");
		u.setPassword("asdf");
		u.setUsername("asdf");
		dao.save(u);
	}

}

