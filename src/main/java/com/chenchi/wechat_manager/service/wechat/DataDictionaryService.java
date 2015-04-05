package com.chenchi.wechat_manager.service.wechat;

import java.util.List;

import com.chenchi.wechat_manager.entity.DataDictionary;

public interface DataDictionaryService {
	/**
	 * 根据dataKey查询dataValue
	 * 
	 * @param dataKey
	 * @return
	 */
	public String getByDataKey(String dataKey);

	/**
	 * 查询语料列表
	 * 
	 * @return
	 */
	public List<DataDictionary> getList();
	/**
	 * 保存语料
	 * 
	 * @param dataDic
	 */
	public void saveDataDic(DataDictionary dataDic);
}
