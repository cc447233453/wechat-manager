package com.chenchi.wechat_manager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chenchi.wechat_manager.entity.TDPoetry;
import com.chenchi.wechat_manager.service.ArticleService;

public class FileTest {

	public static void main(String[] args) {
		// F:\doc\7016.txt
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context/applicationContext.xml");
		ArticleService a = (ArticleService) ctx.getBean("articleService");

		try {
			String encoding = "UTF-8";
			File file = new File("F:/doc/7016.txt");
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				String type = "";
				TDPoetry poetry = null;
				String pContent = "";// 内容
				String note = "";// 注解
				String translation = "";// 韵译
				String analysis = "";// 评析
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
					if ("=============================".equals(lineTxt)) {
						if (poetry != null) {
							poetry.setpContent(pContent.trim());
							poetry.setNote(note.trim());
							poetry.setTranslation(translation.trim());
							poetry.setAnalysis(analysis.trim());
							a.saveArticle(poetry);

						}
						poetry = new TDPoetry();
						type = "";
						pContent = "";
						note = "";
						translation = "";
						analysis = "";
						continue;
					}
					Matcher mather = Pattern.compile("《(.+?)》").matcher(lineTxt);
					if (mather.matches()) {
						poetry.setpName(lineTxt);
						continue;
					}
					if (lineTxt.contains("作者：")) {
						poetry.setpAuthor(lineTxt);
						type = "content";
						continue;
					}
					if (lineTxt.contains("注解")) {
						type = "note";
						continue;
					}
					if (lineTxt.contains("韵译")) {
						type = "explain";
						continue;
					}
					if (lineTxt.contains("评析")) {
						type = "analysis";
						continue;
					}
					if (!"".equals(lineTxt.trim())) {
						if ("note".equals(type)) {
							note = note + "\n" + lineTxt;
						} else if ("explain".equals(type)) {
							translation = translation + "\n" + lineTxt;
						} else if ("analysis".equals(type)) {
							poetry.setAnalysis(lineTxt);
							analysis = analysis + "\n" + lineTxt;
						} else if ("content".equals(type)) {
							pContent = pContent + "\n" + lineTxt;
						}
					}

				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}
}
