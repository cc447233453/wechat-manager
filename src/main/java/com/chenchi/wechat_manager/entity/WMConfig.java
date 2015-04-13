package com.chenchi.wechat_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chenchi.wechat_manager.dao.util.AutoIDEntity;
@Entity
@Table(name = "WM_CONFIG")
public class WMConfig extends AutoIDEntity {

	private String configKey;
	private String configValue;

	@Column(name = "CONFIGKEY", length = 20)
	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	@Column(name = "CONFIGVALUE", length = 200)
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

}
