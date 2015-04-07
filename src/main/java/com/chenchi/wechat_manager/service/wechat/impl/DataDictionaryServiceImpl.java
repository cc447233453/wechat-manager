package com.chenchi.wechat_manager.service.wechat.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenchi.wechat_manager.dao.DataDictionaryDao;
import com.chenchi.wechat_manager.entity.DataDictionary;
import com.chenchi.wechat_manager.service.wechat.DataDictionaryService;
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Resource
	private DataDictionaryDao dataDictionaryDao;
	@Override
	public String getByDataKey(String dataKey, String type) {
		List<DataDictionary> list = dataDictionaryDao.getByDataKey(dataKey, type);
		// 如果查询到对应的语料，则返回，否则去随机词库中查询
		if (list != null && list.size() > 0) {
			return list.get(0).getDataValue();
		} else {
			List<DataDictionary> list1 = dataDictionaryDao.getDataDicByDataType(type);

			if (list1 != null && list1.size() > 0) {
				return list1.get(0).getDataValue();
			} else {
				return "你是一个好人";
			}
		}
	}
	/**
	 * 查询语料列表
	 * 
	 * @return
	 */
	public List<DataDictionary> getList() {
		return dataDictionaryDao.getList();
	}
	/**
	 * 保存语料
	 * 
	 * @param dataDic
	 */
	public void saveDataDic(DataDictionary dataDic) {
		dataDictionaryDao.add(dataDic);
	}
}
