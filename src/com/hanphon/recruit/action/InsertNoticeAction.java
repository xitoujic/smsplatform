/**
 *@time 2011-3-19
 *@author soledad pisces
 *@fileName InsertNoticeAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hanphon.recruit.dao.NoticeDao;
import com.hanphon.recruit.dao.impl.NoticeDaoHibernateImpl;
import com.hanphon.recruit.domain.NoticeDomain;

/**
 * @author soledad pisces
 * 
 */
public class InsertNoticeAction {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private NoticeDomain noticeDomainPublish;

	public void execute() throws IOException {
		this.message = "<msg>ERROR</msg>";
		if (noticeDomainPublish != null) {

			NoticeDao dao = new NoticeDaoHibernateImpl();
			noticeDomainPublish.setTime(new Date());

			Boolean retValBoolean = dao.save(noticeDomainPublish);

			if (retValBoolean == true) {
				this.message = "<msg>SUCCESS</msg>";
			}
		}
		
		sendMsg(message);
	}

	public void sendMsg(String content) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().println(content);
	}

	public NoticeDomain getNoticeDomainPublish() {
		return noticeDomainPublish;
	}

	public void setNoticeDomainPublish(NoticeDomain noticeDomainPublish) {
		this.noticeDomainPublish = noticeDomainPublish;
	}
}
