package com.chenchi.wechat_manager.util;

import java.io.UnsupportedEncodingException;

public class ChangeCharset {
	public static final String GB2312 = "GB2312";
	/** 将字符编码转换成GB2312 */
	public static String toGB2312(String str) throws UnsupportedEncodingException {
		return changeCharset(str, GB2312);
	}
	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换的字符串
	 * @param newCharset
	 *            目标编码
	 */
	public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
			byte[] bs = str.getBytes();
			return new String(bs, newCharset); // 用新的字符编码生成字符串
		}
		return null;
	}

	public static String utf8Togb2312(String str) {

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			switch (c) {

				case '+' :

					sb.append(' ');

					break;

				case '%' :

					try {

						sb.append((char) Integer.parseInt(

								str.substring(i + 1, i + 3), 16));

					}

					catch (NumberFormatException e) {

						throw new IllegalArgumentException();

					}

					i += 2;

					break;

				default :

					sb.append(c);

					break;

			}

		}

		String result = sb.toString();

		String res = null;

		try {

			byte[] inputBytes = result.getBytes("8859_1");

			res = new String(inputBytes, "UTF-8");

		}

		catch (Exception e) {
		}

		return res;

	}
	public static void main(String[] args) {
		utf8Togb2312("崔");
	}
}
