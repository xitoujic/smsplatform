/**
 *@time 2011-4-24
 *@author soledad pisces
 *@fileName SearchStudentByNameAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class SearchStudentByNameAction {
	private int pageNum;
	private String userName;
	private String message;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void searchStudentByNameAction() throws IOException {
		StudentMessageDao dao = new StudentMessageDaoHibernateImpl();
		this.userId = dao.getIdByName(userName);
		
		if(this.userId == null) {
			this.message = "<msg>ERROR</msg>";
		} else {
			this.message = "<msg>SUCCESS</msg>";
			ActionContext.getContext().getSession().put("idHere", userId);
			ActionContext.getContext().getSession().put("pageNums", pageNum);
		}
		
		sendMsg(message);
	}
	
	public void sendMsg(String content) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().println(content);
	}
}
