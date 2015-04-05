package com.chenchi.wechat_manager.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenchi.wechat_manager.dao.ArticleCategoryDao;
import com.chenchi.wechat_manager.dao.ArticleDao;
import com.chenchi.wechat_manager.entity.Article;
import com.chenchi.wechat_manager.entity.ArticleCategory;
import com.chenchi.wechat_manager.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleDao articleDao;

	@Resource
	private ArticleCategoryDao articleCategoryDao;

	@Override
	public List<Article> getList() {
		return articleDao.getlist();
	}

	/**
	 * 保存文章
	 * 
	 * @param article
	 */
	public void saveArticle(Article article) {
		article.setCreateTime(new Date());
		article.setUpdateTime(new Date());
		articleDao.add(article);
	}

	@Override
	public List<Article> getListByCid(long cid) {
		ArticleCategory category = articleCategoryDao.findById(cid);
		return articleDao.findListByCategory(category);
	}
}
