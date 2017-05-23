package com.freemarker.platform.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platform.user.dao.UserDao;
import com.platform.user.dao.impl.UserDaoImpl;
import com.platform.user.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserTest extends AbstractJUnit4SpringContextTests {
	private static Log log = LogFactory.getLog(UserTest.class.getName());

	private UserDao userDao;

	@Test
	public void init() {
		log.debug("开始启动");
		userDao = new UserDaoImpl();
		System.out.println(userDao);
		User user = new User();
		user.setId("1");
		user.setUsername("zhangsan");
		user.setUsername("123456");
		userDao.insert(user);
	}

//	public void insert() {
//		User p = new User();
//		userDao.insert(p);
//		log.debug("添加成功");
//	}
}
