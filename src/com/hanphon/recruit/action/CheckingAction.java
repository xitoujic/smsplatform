/**
 *@time 2011-4-23
 *@author soledad pisces
 *@fileName CheckingAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hanphon.recruit.dao.CheckedResultDao;
import com.hanphon.recruit.dao.impl.CheckedReslutDaoHibernateImpl;
import com.hanphon.recruit.domain.CheckedResultDomain;

/**
 * @author soledad pisces
 * 
 */
public class CheckingAction {
	private String id;
	private String checkedResult;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCheckedResult() {
		return checkedResult;
	}

	public void setCheckedResult(String checkedResult) {
		this.checkedResult = checkedResult;
	}

	public void execute() throws IOException {
		CheckedResultDao dao = new CheckedReslutDaoHibernateImpl();
		CheckedResultDomain domain = new CheckedResultDomain();
		domain.setUserId(id);
		domain.setUserAuditResult("通过");
		Boolean flag = dao.update(domain);
		
		if (flag == true) {
			checkedResult = "<msg>SUCCESS</msg>";
		} else {
			checkedResult = "<msg>ERROR</msg>";
		}
		
		sendMsg(checkedResult);
	}
	
	public void sendMsg(String content) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		response.getWriter().println(content);
	}
}


