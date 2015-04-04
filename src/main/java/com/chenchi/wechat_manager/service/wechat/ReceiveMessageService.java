package com.chenchi.wechat_manager.service.wechat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public interface ReceiveMessageService {
	/**
	 * 验证消息真实性
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public boolean checkSignature(String signature, String timestamp, String nonce) throws NoSuchAlgorithmException, UnsupportedEncodingException;
	/**
	 * 接收消息
	 * 
	 * @param request
	 * @return
	 */
	public String receiveMessage(HttpServletRequest request) throws IOException;
}
