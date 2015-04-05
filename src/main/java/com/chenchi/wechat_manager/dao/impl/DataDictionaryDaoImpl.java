package com.chenchi.wechat_manager.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chenchi.wechat_manager.dao.DataDictionaryDao;
import com.chenchi.wechat_manager.entity.DataDictionary;
@Repository
public class DataDictionaryDaoImpl implements DataDictionaryDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public List<DataDictionary> getByDataKey(String dataKey) {
		String hql = "from DataDictionary where dataKey=?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, dataKey);
		return query.list();
	}

}
