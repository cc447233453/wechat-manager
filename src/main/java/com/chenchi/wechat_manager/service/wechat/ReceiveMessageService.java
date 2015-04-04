package com.chenchi.wechat_manager.service.wechat;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface ReceiveMessageService {
	public boolean checkSignature(String signature, String timestamp, String nonce) throws NoSuchAlgorithmException, UnsupportedEncodingException;
}
