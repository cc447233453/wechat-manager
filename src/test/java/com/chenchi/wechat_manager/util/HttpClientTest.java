package com.chenchi.wechat_manager.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String str = "<xml><URL><![CDATA[http://localhost:8080/wm/wechat/api]]></URL><ToUserName><![CDATA[cc447133453@163.com]]></ToUserName><FromUserName><![CDATA[316849113]]></FromUserName><CreateTime>1999999</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[您好]]></Content><MsgId>111</MsgId></xml>";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://localhost:8080/wm/wechat/api");
		httpPost.setEntity(new StringEntity(str, "utf-8"));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		System.out.println(response2.getStatusLine());
		HttpEntity entity2 = response2.getEntity();
		// do something useful with the response body
		// and ensure it is fully consumed
		EntityUtils.consume(entity2);

	}
}
