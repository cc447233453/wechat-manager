package com.chenchi.wechat_manager.service.wechat.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Service
public class BasicServiceImpl {
	private static final String GRANT_TYPE = "client_credential";
	private static final String APPID = "wxc52abcd8023eb713";
	private static final String SECRET = "b59b6243c8a4aecb0f1c741b0308f12f";
	private static final String WECHAT_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + GRANT_TYPE + "&appid=" + APPID + "&secret=" + SECRET;
	public void getAcceessToken() throws InterruptedException, IOException {
		HttpGet httpGet = new HttpGet(WECHAT_URL);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse response1 = httpClient.execute(httpGet);
		try {
			System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			JSONObject object = JSON.parseObject(EntityUtils.toString(entity1));
			String access_token = object.get("access_token").toString();
			String expires_in = object.get("expires_in").toString();
			Map<String, String> map = new HashMap<String, String>();
			map.put("access_token", access_token);
			map.put("expires_in", expires_in);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
