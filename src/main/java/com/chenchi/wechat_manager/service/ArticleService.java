package com.chenchi.wechat_manager.service;

import java.util.List;

import com.chenchi.wechat_manager.entity.Article;
import com.chenchi.wechat_manager.entity.TDPoetry;

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
	 * 保存唐诗
	 * 
	 * @param article
	 */
	public void saveArticle(TDPoetry poetry);

	/**
	 * @Description 根据ID查找文章
	 * @param id
	 * @return
	 * @see 需要参考的类或方法
	 */
	public Article findById(long id);
	/**
	 * @Description 根据ID查找唐诗
	 * @param id
	 * @return
	 * @see 需要参考的类或方法
	 */
	public TDPoetry findPoetryById(long id);
}
