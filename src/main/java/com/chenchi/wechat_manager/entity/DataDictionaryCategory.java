package com.chenchi.wechat_manager.entity;

import com.chenchi.wechat_manager.dao.util.AutoIDEntity;

public class DataDictionaryCategory extends AutoIDEntity {
	/**
	 * 分类编号
	 */
	private String categoryId;
	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 * 是否有效
	 */
	private String isDisable;
}
