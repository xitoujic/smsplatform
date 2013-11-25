/**
 *@time 2011-3-14
 *@author soledad pisces
 *@fileName RegisterAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hanphon.recruit.Utils.EmailUtil;
import com.hanphon.recruit.dao.RegisterMessageDao;
import com.hanphon.recruit.dao.impl.RegisterMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.RegisterMessageDomain;

/**
 * @author soledad pisces
 * 
 */
public class RegisterAction {
	private String emailAddress;
	private String password1;
	private String passwordConfirm;
	private String json;

	public void execute() throws IOException {

		if ("".equals(emailAddress.trim()) || emailAddress == null) {
			json = "<msg>ERROR</msg>";
		}
		if ("".equals(password1.trim()) || password1 == null) {
			json = "<msg>ERROR</msg>}";
		}
		if ("".equals(passwordConfirm.trim()) || passwordConfirm == null) {
			json = "<msg>ERROR</msg>";
		}
		if (!passwordConfirm.equals(password1)) {
			json = "<msg>ERROR</msg>";
		}

		// Save
		{
			RegisterMessageDomain reDomain = new RegisterMessageDomain();
			reDomain.setIsStudent("Y");
			reDomain.setOnStatus("1");
			/*
			 * 1:表示注册状态 2:表示登陆过 3：提交基本信息 4：已经下载申请表，等待考核 5：考核通过，等待考试
			 * 6：参加了考试，等待考试成绩 7：已经录取
			 */
			reDomain.setUserEmail(emailAddress);
			reDomain.setUserPassword(password1);

			RegisterMessageDao<RegisterMessageDomain, String> reHibernateDao = new RegisterMessageDaoHibernateImpl();
			Boolean resVal = reHibernateDao.save(reDomain);
			System.out.println(resVal);
			if (resVal == true) {
				EmailUtil emailUtil = new EmailUtil();
				emailUtil.sendEmail(emailAddress, password1);
				json = "<msg>SUCCESS</msg>";
			} else {
				json = "<msg>ERROR</msg>";
			}

		}
		sendMsg(json);
	}

	public void sendMsg(String content) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().println(content);
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
