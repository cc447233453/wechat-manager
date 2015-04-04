package com.chenchi.wechat_manager.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JedisUtilTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context/applicationContext.xml");

		JedisUtil.setKeyValue("xiaocui", "123", 3600);

		System.out.println(JedisUtil.getValue("xiaocui"));

	}
}
