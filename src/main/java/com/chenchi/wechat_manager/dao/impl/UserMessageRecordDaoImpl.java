package com.chenchi.wechat_manager.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chenchi.wechat_manager.dao.UserMessageRecordDao;
import com.chenchi.wechat_manager.entity.UserMessageRecord;
@Repository
public class UserMessageRecordDaoImpl implements UserMessageRecordDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void add(UserMessageRecord userMessageRecord) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userMessageRecord);
	}

}
