package com.chenchi.wechat_manager.service;

import java.util.List;

import com.chenchi.wechat_manager.entity.Article;

public interface ArticleService {
	/**
	 * @Description 查询文章列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Article> getList();

	/**
	 * @Description 查询分类文章列表
	 * @param cid
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Article> getListByCid(long cid);

	/**
	 * 保存文章
	 * 
	 * @param article
	 */
	public void saveArticle(Article article);

	/**
	 * @Description 根据ID查找文章
	 * @param id
	 * @return
	 * @see 需要参考的类或方法
	 */
	public Article findById(long id);
}
