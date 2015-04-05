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
	/**
	 * 查询type=0
	 * 
	 * @return
	 */
	public List<DataDictionary> getDataDicByDataType(String type) {
		String hql = "from DataDictionary where dataType=? order by rand() limit 1 ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setString(0, type);
		return query.list();
	}
	/**
	 * 查询列表
	 * 
	 * @return
	 */
	public List<DataDictionary> getList() {
		String hql = "from DataDictionary ";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}

	/**
	 * @Description 创建语料
	 * @param article
	 * @see 需要参考的类或方法
	 */
	public void add(DataDictionary dataDictionary) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dataDictionary);
	}
}
