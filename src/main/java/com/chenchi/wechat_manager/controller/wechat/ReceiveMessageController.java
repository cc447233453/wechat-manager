package com.chenchi.wechat_manager.controller.wechat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenchi.wechat_manager.service.wechat.ReceiveMessageService;

@Controller
@RequestMapping("/wechat/")
public class ReceiveMessageController {
	@Resource
	public ReceiveMessageService receiveMessService;
	@RequestMapping(value = "api", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String api(HttpServletRequest request, HttpServletResponse response) {
		boolean isGet = request.getMethod().toLowerCase().equals("get");
		if (isGet) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			try {
				boolean checkResult = receiveMessService.checkSignature(signature, timestamp, nonce);
				if (checkResult) {
					return echostr;
				} else {
					return null;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("------------post-----------");
				return receiveMessService.receiveMessage(request);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
