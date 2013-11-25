/**
 *@time 2011-3-14
 *@author soledad pisces
 *@fileName EmailUtil.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


/**
 * @author soledad pisces
 * 
 */
public final class EmailUtil {
	private Properties prop = null;

	public EmailUtil() {
		InputStream isInputStream = EmailUtil.class.getClassLoader()
				.getResourceAsStream("simpleEmail.properties");

		prop = new Properties();
		try {
			prop.load(isInputStream);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmail(String emailAddress, String password) {
		SimpleEmail simpleEmail = new SimpleEmail();
		simpleEmail.setHostName(prop.getProperty("hostName"));
		simpleEmail
				.setAuthentication(prop.getProperty("userName"), prop.getProperty("password"));
		simpleEmail.setCharset("UTF-8");

		try {
			simpleEmail.setFrom(prop.getProperty("from"));
			simpleEmail.addTo(emailAddress);
			simpleEmail.setSubject("Hanphon recruit register!");
			simpleEmail.setMsg("恭喜您成功注册了Hanphon recruit的用户名和密码\n" + "用户名:"
					+ emailAddress + "\n密码:" + password
					+ "\n请谨慎保管，如果丢失密码请使用本邮箱查找密码！");
			simpleEmail.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}

	}
}
