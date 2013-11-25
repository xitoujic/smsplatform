/**
 *@time 2011-4-17
 *@author soledad pisces
 *@fileName ApplicationGetAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.StudentDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 *
 */
public class ApplicationGetAction {
	private StudentDomain studentDomain;
	
	public String execute() {
		StudentMessageDao studentDao = new StudentMessageDaoHibernateImpl();
		this.studentDomain = studentDao.findById((String) ActionContext
				.getContext().getSession().get("uid"));
		if(this.studentDomain==null)
			return "fail";
		return "success";
	}

	public StudentDomain getStudentDomain() {
		return studentDomain;
	}

	public void setStudentDomain(StudentDomain studentDomain) {
		this.studentDomain = studentDomain;
	}
}
