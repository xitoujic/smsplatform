/**
 *@time 2011-3-29
 *@author soledad pisces
 *@fileName UpdateMessageAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.UnsupportedEncodingException;

import com.hanphon.recruit.dao.RegisterMessageDao;
import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.RegisterMessageDaoHibernateImpl;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.RegisterMessageDomain;
import com.hanphon.recruit.domain.StudentDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class UpdateMessageAction {
	private StudentDomain studentDomain;
	private String category1;
	private String category2;
	private String status;
	private String id;
	private int pageNum;

	public String execute() throws UnsupportedEncodingException {
		if (studentDomain != null) {

			category1 = (String) ActionContext.getContext()
					.getSession().get("category1");
			category2 = (String) ActionContext.getContext()
					.getSession().get("category2");
			status = (String) ActionContext.getContext()
					.getSession().get("status");
			id = (String) ActionContext.getContext()
					.getSession().get("id");
//			
//			System.out.println("----"+pageNum);
//			
//			pageNum = ((Integer)ActionContext.getContext().getSession().get("pageNum")).intValue();
//			
//			System.out.println("+++++"+pageNum);

			RegisterMessageDao<RegisterMessageDomain, String> dao = new RegisterMessageDaoHibernateImpl();
			RegisterMessageDomain registerMessageDomain = dao
					.findById((String) ActionContext.getContext().getSession()
							.get("id"));

			studentDomain.setUserEmail(registerMessageDomain.getUserEmail());
			studentDomain.setUserPassword(registerMessageDomain
					.getUserPassword());
			studentDomain.setIsStudent(registerMessageDomain.getIsStudent());
			studentDomain.setOnStatus(registerMessageDomain.getOnStatus());
			studentDomain.setUserId(registerMessageDomain.getUserId());

			StudentMessageDao studentMessageDao = new StudentMessageDaoHibernateImpl();
			studentMessageDao.update(studentDomain);
			return "success";
		}
		return "fail";
	}

	public StudentDomain getStudentDomain() {
		return studentDomain;
	}

	public void setStudentDomain(StudentDomain studentDomain) {
		this.studentDomain = studentDomain;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


}
