package com.chenchi.wechat_manager.controller.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenchi.wechat_manager.entity.Article;
import com.chenchi.wechat_manager.entity.ArticleCategory;
import com.chenchi.wechat_manager.service.ArticleCategoryService;
import com.chenchi.wechat_manager.service.ArticleService;

/**
 * 
 * @Description: 文章管理
 * @see: ArticleController
 * @version 2015年3月29日 下午8:44:03
 * @author chenchi
 */
@Controller
@RequestMapping("/manager/")
public class ArticleController {
	@Resource
	public ArticleService articleService;
	@Resource
	private ArticleCategoryService articleCategoryService;

	@RequestMapping("managerArticles")
	public String managerArticles(HttpServletRequest request) {
		return "manager/queryArticles";
	}

	/**
	 * 查询文章列别
	 * 
	 * @return
	 */
	@RequestMapping("queryArticles")
	@ResponseBody
	public List<Article> queryArticles() {
		List<Article> list = articleService.getList();
		return list;
	}

	@RequestMapping("addArticlePre")
	public String addArticlePre(HttpServletRequest request) {
		List<ArticleCategory> list = articleCategoryService.getList();

		request.setAttribute("list", list);
		return "manager/articleAdd";
	}

	@RequestMapping("saveArticle")
	@ResponseBody
	public Map<String, Object> saveArticle(HttpServletRequest request, Article article, String categoryid) {
		Map<String, Object> map = new HashMap<String, Object>();

		long cid = Long.parseLong(categoryid);

		ArticleCategory category = articleCategoryService.findById(cid);
		String author = (String) request.getSession().getAttribute("userName");
		article.setAuthor(author);
		article.setArticleCategory(category);
		articleService.saveArticle(article);
		map.put("errorMsg", false);
		return map;
	}
}
