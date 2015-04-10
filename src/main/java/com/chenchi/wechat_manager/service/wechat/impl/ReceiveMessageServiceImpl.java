package com.chenchi.wechat_manager.service.wechat.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenchi.wechat_manager.dao.UserMessageRecordDao;
import com.chenchi.wechat_manager.entity.InputMessage;
import com.chenchi.wechat_manager.entity.OutputMessage;
import com.chenchi.wechat_manager.entity.UserMessageRecord;
import com.chenchi.wechat_manager.enums.MsgType;
import com.chenchi.wechat_manager.service.wechat.DataDictionaryService;
import com.chenchi.wechat_manager.service.wechat.ReceiveMessageService;
import com.chenchi.wechat_manager.util.CnToStrokeCount;
import com.chenchi.wechat_manager.util.JedisUtil;
import com.chenchi.wechat_manager.util.SerializeXmlUtil;
import com.thoughtworks.xstream.XStream;

@Service
public class ReceiveMessageServiceImpl implements ReceiveMessageService {
	@Resource
	private UserMessageRecordDao userMessageRecordDao;
	@Resource
	private DataDictionaryService dataDictionaryService;
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
		String servername = inputMsg.getToUserName();// 鏈嶅姟绔�
		String custermname = inputMsg.getFromUserName();// 瀹㈡埛绔�
		long createTime = inputMsg.getCreateTime();// 鎺ユ敹鏃堕棿
		Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 杩斿洖鏃堕棿
		String msgType = inputMsg.getMsgType();// // 取得消息类型
		System.out.println("******msgType************" + msgType);

		if (msgType.equals(MsgType.text.toString())) {
			String content = inputMsg.getContent();
			// 保存用户查询信息 begin
			UserMessageRecord userMessageRecord = new UserMessageRecord();
			userMessageRecord.setMessage(content);
			userMessageRecord.setCreateTime(new Date());
			userMessageRecord.setCustomerName(custermname);
			userMessageRecordDao.add(userMessageRecord);
			StringBuffer dataValue = new StringBuffer();
			// 用户发起查询请求，将请求存在redis中。如果改累请求已存在，则查询该类内容
			// 如果查询请求不存在，返回用户提示信息，输入特定内容，进行分类查询
			String userContent = JedisUtil.getValue(custermname);

			Pattern pattern = Pattern.compile("[1-7]");
			Matcher mather = pattern.matcher(content);
			if (mather.matches()) {
				JedisUtil.setKeyValue(custermname, content, 3600);
				if ("1".equals(content)) {
					dataValue.append(dataDictionaryService.getByDataKey(content, content));
				} else if ("6".equals(content)) {
					dataValue.append("回复   **和** 测试缘分。例如:  习大大和彭妈妈");
				} else if ("7".equals(content)) {
					dataValue.append("您已进入b612星球,与小王子一起开始旅行吧");
				} else {
					dataValue.append("精彩功能，敬请期待");
				}
			} else if (!"".equals(userContent) && userContent != null && !mather.matches()) {

				if ("6".equals(userContent)) {
					String firstName = content.split("和")[0];
					String secondName = content.split("和")[1];
					int firstNameCount = this.sixType(firstName);
					int secondNameCount = this.sixType(secondName);
					if (firstNameCount >= secondNameCount) {
						content = (firstNameCount - secondNameCount) + "";
					} else {
						content = (secondNameCount - firstNameCount) + "";
					}
				}
				dataValue.append(dataDictionaryService.getByDataKey(content, userContent));
			} else {
				dataValue.append("呃...您的问题难倒我了。您可以输入以下数字来和小c聊天\n");
				dataValue.append("[1]小c唐诗\n");
				dataValue.append("[2]小c百科\n");
				dataValue.append("[3]小c常识\n");
				dataValue.append("[4]小c旅行\n");
				dataValue.append("[5]小c鸡汤\n");
				dataValue.append("[6]小c缘分\n");
				dataValue.append("[7]小c乱弹\n");
			}

			System.out.println("dataKey:" + content);
			System.out.println("dataValue:" + dataValue);
			StringBuffer str = new StringBuffer();
			str.append("<xml>");
			str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
			str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
			str.append("<CreateTime>" + returnTime + "</CreateTime>");
			str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
			str.append("<Content><![CDATA[");
			str.append(dataValue.toString());
			str.append("]]></Content>");
			str.append("</xml>");

			System.out.println(str.toString());
			return str.toString();
		}
		return "";
	}
	/**
	 * [6]小c测缘分
	 * 
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public int sixType(String str) throws UnsupportedEncodingException {
		int count = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			count += CnToStrokeCount.getStrokeCount(chars[i]);
		}
		return count;
	}
}
