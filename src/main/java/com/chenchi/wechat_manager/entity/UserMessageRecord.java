package com.chenchi.wechat_manager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chenchi.wechat_manager.dao.util.AutoIDEntity;
@Entity
@Table(name = "WM_USER_MESSAGE_RECORDER")
public class UserMessageRecord extends AutoIDEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 消息内容
	 */
	private String message;
	/**
	 * 创建时间
	 */
	private Date createTime;

	@Column(name = "MESSAGE", length = 200)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
