package com.chenchi.wechat_manager.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chenchi.wechat_manager.dao.WMConfigDao;
import com.chenchi.wechat_manager.entity.WMConfig;
@Repository
public class WMConfigDaoImpl implements WMConfigDao {

	@Resource
	private SessionFactory sessionFactory;
	public WMConfig findByConfigKey(String key) {
		String hql = "from WMConfig where configKey = ?";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, key);

		return (WMConfig) query.uniqueResult();
	}
}
