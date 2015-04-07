package com.chenchi.wechat_manager.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chenchi.wechat_manager.dao.ArticleDao;
import com.chenchi.wechat_manager.entity.Article;
import com.chenchi.wechat_manager.entity.ArticleCategory;

/**
 * 
 * @Description: 这里用一句话描述这个类的作用
 * @see: ArticleDaoImpl 此处填写需要参考的类
 * @version 2015年3月29日 下午8:36:42
 * @author chenchi
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Article> getlist() {
		String hql = "from Article ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public Article findById(long id) {
		String hql = "from Article where id = ?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, id);

		List<Article> list = query.list();

		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void add(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.save(article);

	}

	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Article> findListByCategory(ArticleCategory category) {
		String hql = "from Article where articleCategory.id = ?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, category.getId());
		return query.list();
	}

}
