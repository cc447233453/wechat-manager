package com.chenchi.wechat_manager.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chenchi.wechat_manager.dao.ArticleCategoryDao;
import com.chenchi.wechat_manager.entity.ArticleCategory;

@Repository
public class ArticleCategoryDaoImpl implements ArticleCategoryDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<ArticleCategory> getlist() {
		String hql = "from ArticleCategory ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public ArticleCategory findById(long cid) {
		String hql = "from ArticleCategory where id = ?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, cid);

		List<ArticleCategory> list = query.list();

		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
