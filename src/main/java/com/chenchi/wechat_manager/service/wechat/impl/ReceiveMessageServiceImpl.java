package com.chenchi.wechat_manager.service.wechat.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chenchi.wechat_manager.service.wechat.ReceiveMessageService;
@Service
public class ReceiveMessageServiceImpl implements ReceiveMessageService {

	public boolean checkSignature(String signature, String timestamp, String nonce) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String token = "chenchi_weixin2015";
		List<String> tmpArr = new ArrayList<String>();
		tmpArr.add(timestamp);
		tmpArr.add(nonce);
		tmpArr.add(token);
		Collections.sort(tmpArr);
		String tmpStr = "";
		for (int i = 0; i < tmpArr.size(); i++) {
			tmpStr += tmpArr.get(i);
		}
		System.out.println("tmpStr-----------" + tmpStr);
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(tmpStr.getBytes("UTF-8"));
		byte[] result = md.digest();

		StringBuffer sb = new StringBuffer();

		for (byte b : result) {
			int i = b & 0xff;
			if (i < 0xf) {
				sb.append(0);
			}
			sb.append(Integer.toHexString(i));
		}
		tmpStr = sb.toString().toLowerCase();
		System.out.println("tmpStr+++++++++++" + tmpStr);
		System.out.println("signature************" + signature);
		if (tmpStr.equals(signature)) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		ReceiveMessageServiceImpl a = new ReceiveMessageServiceImpl();
		try {
			String aaa = new Date().getTime() + "";
			a.checkSignature("", aaa, "12321");
			System.out.println(aaa);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
