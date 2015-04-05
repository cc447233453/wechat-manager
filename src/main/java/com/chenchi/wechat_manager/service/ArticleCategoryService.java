package com.chenchi.wechat_manager.service;

import java.util.List;

import com.chenchi.wechat_manager.entity.ArticleCategory;

public interface ArticleCategoryService {
	/**
	 * @Description 查询文章分类列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<ArticleCategory> getList();

	/**
	 * @Description 根据ID查找
	 * @param cid
	 * @return
	 * @see 需要参考的类或方法
	 */
	public ArticleCategory findById(long cid);
}
