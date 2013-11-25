/**
 *@time 2011-4-22
 *@author soledad pisces
 *@fileName DeleteNoticeAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hanphon.recruit.dao.NoticeDao;
import com.hanphon.recruit.dao.impl.NoticeDaoHibernateImpl;
import com.hanphon.recruit.domain.NoticeDomain;

/**
 * @author soledad pisces
 *
 */
public class DeleteNoticeAction {
	private int id;
	private String message;
	
	public void delete() throws IOException{
		NoticeDao dao = new NoticeDaoHibernateImpl();
		NoticeDomain domain = dao.findById(id);
		Boolean flag = dao.delete(domain);
		
		if(flag == true){
			message = "<msg>SUCCESS</msg>";
		} else {
			message = "<msg>ERROR</msg>";
		}
		
		sendMsg(message);
	}
	
	public void sendMsg(String content) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().println(content);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
