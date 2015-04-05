package com.chenchi.wechat_manager.service.wechat;

public interface DataDictionaryService {
	/**
	 * 根据dataKey查询dataValue
	 * 
	 * @param dataKey
	 * @return
	 */
	public String getByDataKey(String dataKey);
}
