/**
 *@time 2011-3-14
 *@author soledad pisces
 *@fileName ToZoneAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.util.List;

import com.hanphon.recruit.dao.NoticeDao;
import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.NoticeDaoHibernateImpl;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.NoticeDomain;
import com.hanphon.recruit.domain.StudentDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class ToZoneAction {
	private String messageNotice;
	private List<NoticeDomain> noticeDomains;

	public String execute() {
		this.messageNotice = "您好!\t"
				+ ActionContext.getContext().getSession().get("userName")
				+ "\t" + "已经成功登陆本系统<br><br>";

		ActionContext.getContext().getSession().put("messageNotice", this.messageNotice);
		
		NoticeDao dao = new NoticeDaoHibernateImpl();
		noticeDomains = dao.getAll();

		String string = (String) ActionContext.getContext().getSession().get(
				"isStudent");

		if ("Y".equals(string)) {
			StudentMessageDao studentDao = new StudentMessageDaoHibernateImpl();
			 StudentDomain studentDomain = studentDao.findById((String) ActionContext
					.getContext().getSession().get("uid"));

			if (studentDomain.getOnStatus().equals("1")) {
				studentDao.setOnStatus(studentDomain.getUserId(), "2");
			} 
			return "studentZone";
		} else {
			
			return "teacherZone";
		}
	}

	public String getMessageNotice() {
		return messageNotice;
	}

	public void setMessageNotice(String messageNotice) {
		this.messageNotice = messageNotice;
	}

	public List<NoticeDomain> getNoticeDomains() {
		return noticeDomains;
	}

	public void setNoticeDomains(List<NoticeDomain> noticeDomains) {
		this.noticeDomains = noticeDomains;
	}

}
