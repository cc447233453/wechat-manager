package com.chenchi.wechat_manager.controller.wechat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public @ResponseBody String api(HttpServletRequest request, HttpServletResponse response) {

		boolean isGet = request.getMethod().toLowerCase().equals("get");

		if (isGet) {
			String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			String echostr = request.getParameter("echostr");
			try {
				boolean checkResult = receiveMessService.checkSignature(signature,
						timestamp, nonce);
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
				ServletInputStream in = request.getInputStream();
				StringBuilder xmlMsg = new StringBuilder();
				byte[] b = new byte[4096];
				for (int n; (n = in.read(b)) != -1;) {
					xmlMsg.append(new String(b, 0, n, "UTF-8"));
				}

				System.out.println("------------post-----------");
				String str = receiveMessService.receiveMessage(xmlMsg.toString());
				return str;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
