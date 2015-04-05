package com.chenchi.wechat_manager.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenchi.wechat_manager.dao.ArticleCategoryDao;
import com.chenchi.wechat_manager.entity.ArticleCategory;
import com.chenchi.wechat_manager.service.ArticleCategoryService;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
	@Resource
	private ArticleCategoryDao articleCategoryDao;

	@Override
	public List<ArticleCategory> getList() {
		return articleCategoryDao.getlist();
	}

	@Override
	public ArticleCategory findById(long cid) {
		return articleCategoryDao.findById(cid);
	}

}
