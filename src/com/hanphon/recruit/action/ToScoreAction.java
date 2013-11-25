/**
 *@time 2011-4-17
 *@author soledad pisces
 *@fileName ToScoreAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import com.hanphon.recruit.dao.StudentScoreMessageDao;
import com.hanphon.recruit.dao.impl.StudentScoreDaoHiberneteImpl;
import com.hanphon.recruit.domain.StudentScoreDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class ToScoreAction {
	private StudentScoreDomain studentDomain;

	public String execute() {
		StudentScoreMessageDao studentDao = new StudentScoreDaoHiberneteImpl();
		this.studentDomain = studentDao.findById((String) ActionContext
				.getContext().getSession().get("uid"));

		if (this.studentDomain == null) {
			return "fail";
		}
		return "success";
	}

	public StudentScoreDomain getStudentDomain() {
		return studentDomain;
	}

	public void setStudentDomain(StudentScoreDomain studentDomain) {
		this.studentDomain = studentDomain;
	}

}
