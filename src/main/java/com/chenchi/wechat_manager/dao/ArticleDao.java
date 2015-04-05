package com.chenchi.wechat_manager.dao;

import java.util.List;

import com.chenchi.wechat_manager.entity.Article;
import com.chenchi.wechat_manager.entity.ArticleCategory;

/**
 * @Description: 文章操作dao
 * @see: ArticleDao 此处填写需要参考的类
 * @version 2015年3月28日 下午5:32:14
 * @author chenchi
 */
public interface ArticleDao {

	/**
	 * @Description 获取文章列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Article> getlist();

	/**
	 * @Description 根据id 查找
	 * @return
	 * @see 需要参考的类或方法
	 */
	public Article findById();

	/**
	 * @Description 创建文章
	 * @param article
	 * @see 需要参考的类或方法
	 */
	public void add(Article article);

	/**
	 * @Description 更新文章
	 * @param article
	 * @see 需要参考的类或方法
	 */
	public void update(Article article);

	/**
	 * @Description 查询分类文章列表
	 * @param category
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Article> findListByCategory(ArticleCategory category);
}
