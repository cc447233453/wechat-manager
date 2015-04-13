package com.chenchi.wechat_manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.chenchi.wechat_manager.dao.util.AutoIDEntity;
/**
 * 唐诗实体类
 * 
 * @author cuiyan
 *
 */
@Entity
@Table(name = "WM_TDPOETRY")
public class TDPoetry extends AutoIDEntity {
	private Integer solrId;
	/**
	 * 诗名
	 */
	private String pName;
	/**
	 * 作者
	 */
	private String pAuthor;
	/**
	 * 内容
	 */
	private String pContent;
	/**
	 * 注解
	 */
	private String note;
	/**
	 * 韵译
	 */
	private String translation;
	/**
	 * 评析
	 */
	private String analysis;

	@Column(name = "P_NAME", length = 60)
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	@Column(name = "P_AUTHOR", length = 20)
	public String getpAuthor() {
		return pAuthor;
	}
	public void setpAuthor(String pAuthor) {
		this.pAuthor = pAuthor;
	}
	@Type(type = "text")
	@Column(name = "P_CONTENT")
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	@Type(type = "text")
	@Column(name = "NOTE")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Type(type = "text")
	@Column(name = "TRANSLATION")
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	@Type(type = "text")
	@Column(name = "ANALYSIS")
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public Integer getSolrId() {
		return solrId;
	}
	public void setSolrId(Integer solrId) {
		this.solrId = solrId;
	}

}
