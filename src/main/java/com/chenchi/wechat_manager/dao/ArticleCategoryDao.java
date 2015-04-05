package com.chenchi.wechat_manager.dao;

import java.util.List;

import com.chenchi.wechat_manager.entity.ArticleCategory;

/**
 * 文章分类
 * 
 * @author cuiyan
 *
 */
public interface ArticleCategoryDao {
	/**
	 * @Description 获取文章列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<ArticleCategory> getlist();

	/**
	 * @Description 根据id查找
	 * @return
	 * @see 需要参考的类或方法
	 */
	public ArticleCategory findById(long cid);
}
