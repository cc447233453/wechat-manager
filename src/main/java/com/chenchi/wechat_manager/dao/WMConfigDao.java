package com.chenchi.wechat_manager.dao;

import com.chenchi.wechat_manager.entity.WMConfig;

public interface WMConfigDao {
	public WMConfig findByConfigKey(String key);
}
