package com.chenchi.wechat_manager.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenchi.wechat_manager.entity.Article;
import com.chenchi.wechat_manager.service.ArticleService;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Resource
	private ArticleService articleService;

	/**
	 * 微站首页
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "/user/index";
	}

	/**
	 * @Description 关于我们
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("aboutus")
	public String aboutUs() {
		return "/user/aboutUs";
	}

	/**
	 * @Description 教育理念
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("education")
	public String education() {
		return "/user/education";
	}

	/**
	 * @Description 课程列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("timetable")
	public String timetable() {
		return "/user/timetable";
	}

	@RequestMapping("articlelist")
	public String atticleList(HttpServletRequest request, String cid) throws Exception {

		if (StringUtils.isEmpty(cid)) {
			throw new Exception("文章分类id为空");
		}

		long cidLong = Long.parseLong(cid);

		List<Article> articleList = articleService.getListByCid(cidLong);

		request.setAttribute("list", articleList);
		return "/user/articleList";
	}
}
