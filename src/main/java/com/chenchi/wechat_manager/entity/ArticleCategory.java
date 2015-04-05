package com.chenchi.wechat_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.chenchi.wechat_manager.dao.util.AutoIDEntity;

/**
 * 文章分类信息
 * 
 * @author cuiyan 20150404
 *
 */
@Entity
@Table(name = "WM_ARTICLE_CATEGORY")
public class ArticleCategory extends AutoIDEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * 分类名称
	 */
	private String category;
	/**
	 * 父Id
	 */
	private Long pid;
	@Column(name = "category")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Column(name = "pid")
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}

}
