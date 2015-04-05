package com.chenchi.wechat_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.chenchi.wechat_manager.dao.util.AutoIDEntity;
/**
 * 词库实体类
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "WM_DATA_DICTIONARY")
public class DataDictionary extends AutoIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dataKey;
	private String dataValue;
	private String dataType;
	@Column(name = "DATA_KEY")
	public String getDataKey() {
		return dataKey;
	}
	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}
	@Type(type = "text")
	@Column(name = "DATA_VALUE")
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	@Column(name = "DATA_TYPE")
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}
