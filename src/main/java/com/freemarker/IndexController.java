package com.freemarker;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.platform.user.dao.UserDao;
import com.platform.user.entity.User;

/**
 * Created by huangyuan on 16-4-28.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "toHome")
	public ModelAndView toIndex(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
		int pageSize = StringUtils.isNotEmpty(request.getParameter("pageSize"))
				? Integer.parseInt(request.getParameter("pageSize")) : 5;
		int pageNo = StringUtils.isNotEmpty(request.getParameter("pageNo"))
				? Integer.parseInt(request.getParameter("pageNo")) : 1;
		mv.addObject("pageSize", pageSize);
		mv.addObject("username", request.getParameter("username"));
		mv.addObject("pageNo", pageNo);
		mv.addObject("url", "toHome");
		mv.addObject("recordCount", 1000);
		mv.addObject("ctx", request.getServletContext().getContextPath());
		mv.addObject("title", "Spring MVC And Freemarker");
		mv.addObject("content", " Hello world ， test my first spring mvc ! ");

		if (userDao != null) {
			System.out.println(userDao);
			User user = new User();
			user.setId("1");
			user.setUsername("zhangsan");
			user.setUsername("123456");
			userDao.insert(user);
		} else {
			System.out.println("对象为空值...");
		}
		return mv;
	}
}
