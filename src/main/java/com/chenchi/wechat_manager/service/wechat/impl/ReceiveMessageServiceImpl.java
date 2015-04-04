package com.chenchi.wechat_manager.service.wechat.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chenchi.wechat_manager.entity.InputMessage;
import com.chenchi.wechat_manager.entity.OutputMessage;
import com.chenchi.wechat_manager.enums.MsgType;
import com.chenchi.wechat_manager.service.wechat.ReceiveMessageService;
import com.chenchi.wechat_manager.util.SerializeXmlUtil;
import com.thoughtworks.xstream.XStream;

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
		if (tmpStr.equals(signature)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 接收消息
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String receiveMessage(String document) throws IOException {
		XStream xs = SerializeXmlUtil.createXstream();
		xs.processAnnotations(InputMessage.class);
		xs.processAnnotations(OutputMessage.class);
		xs.alias("xml", InputMessage.class);

		// 将xml内容转换为InputMessage对象
		InputMessage inputMsg = (InputMessage) xs.fromXML(document);
		String servername = inputMsg.getToUserName();// 服务端
		String custermname = inputMsg.getFromUserName();// 客户端
		long createTime = inputMsg.getCreateTime();// 接收时间
		Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间
		String msgType = inputMsg.getMsgType();// // 取得消息类型
		System.out.println("******msgType************" + msgType);
		if (msgType.equals(MsgType.text.toString())) {
			System.out.println("content:" + inputMsg.getContent());
			StringBuffer str = new StringBuffer();
			str.append("<xml>");
			str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
			str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
			str.append("<CreateTime>" + returnTime + "</CreateTime>");
			str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
			str.append("<Content><![CDATA[");
			str.append("您的信息已经记录，请耐心等待！");
			str.append("]]></Content>");
			str.append("</xml>");

			System.out.println(str.toString());
			return str.toString();
		}
		return "";
	}
}
