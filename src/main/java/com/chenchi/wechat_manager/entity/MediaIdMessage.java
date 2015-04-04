package com.chenchi.wechat_manager.entity;

import com.chenchi.wechat_manager.service.wechat.XStreamCDATA;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class MediaIdMessage {
	@XStreamAlias("MediaId")
	@XStreamCDATA
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
