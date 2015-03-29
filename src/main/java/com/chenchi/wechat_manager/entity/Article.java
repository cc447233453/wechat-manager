package com.chenchi.wechat_manager.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.chenchi.wechat_manager.dao.util.AutoIDEntity;

/**
 * @Description: 文章信息
 * @see: Article 此处填写需要参考的类
 * @version 2015年3月28日 下午4:47:19
 * @author chenchi
 */
@Entity
@Table(name = "WM_ARTICLE")
public class Article extends AutoIDEntity {

	private static final long serialVersionUID = 1L;

	String title; // 文章标题
	String content; // 文章内容
	String author; // 作者
	Date createTime; // 创建时间
	Date updateTime; // 修改时间

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Type(type = "text")
	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "AUTHOR", length = 100)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", author=");
		builder.append(author);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append("]");
		return builder.toString();
	}

}
