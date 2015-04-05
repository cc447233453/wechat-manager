package com.chenchi.wechat_manager.dao;

import java.util.List;

import com.chenchi.wechat_manager.entity.DataDictionary;

public interface DataDictionaryDao {
	/**
	 * 根据dataKey查询dataValue
	 * 
	 * @param dataKey
	 * @return
	 */
	public List<DataDictionary> getByDataKey(String dataKey);
}
