package com.chenchi.wechat_manager.controller.wechat;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenchi.wechat_manager.service.wechat.ReceiveMessageService;

@Controller
@RequestMapping("/wechat/")
public class ReceiveMessageController {
	@Resource
	public ReceiveMessageService receiveMessService;
	@RequestMapping("api")
	@ResponseBody
	public String api(String signature, String timestamp, String nonce, String echostr) {
		return "";
		// boolean result = false;
		// try {
		// result = receiveMessService.checkSignature(signature, timestamp,
		// nonce);
		// } catch (NoSuchAlgorithmException e) {
		// e.printStackTrace();
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// System.out.println(result);
		// if (result) {
		// return echostr;
		// } else {
		// return "";
		// }
	}
}
