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
	public List<DataDictionary> getByDataKey(String dataKey, String type);
	/**
	 * 查询type=0
	 * 
	 * @return
	 */
	public List<DataDictionary> getDataDicByDataType(String type);
	/**
	 * 查询列表
	 * 
	 * @return
	 */
	public List<DataDictionary> getList();

	/**
	 * @Description 创建语料
	 * @param article
	 * @see 需要参考的类或方法
	 */
	public void add(DataDictionary dataDictionary);
}
