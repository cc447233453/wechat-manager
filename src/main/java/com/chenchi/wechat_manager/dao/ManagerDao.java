package com.chenchi.wechat_manager.dao;

import java.util.List;

import com.chenchi.wechat_manager.entity.Manager;

/**
 * @Description: 后台操作员dao
 * @see: ManagerDao 此处填写需要参考的类
 * @version 2015年1月19日 下午5:58:49
 * @author chenchi
 */

public interface ManagerDao {

	/**
	 * @Description 查询操作员列表
	 * @return
	 * @see 需要参考的类或方法
	 */
	public List<Manager> getList();

	/**
	 * @Description 根据用户名查找操作员
	 * @param userName
	 * @return
	 * @see 需要参考的类或方法
	 */
	public Manager findByUsername(String userName);

	/**
	 * @Description 创建操作员
	 * @param manager
	 * @see 需要参考的类或方法
	 */
	public void add(Manager manager);
}
