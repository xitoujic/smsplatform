/**
 *@time 2011-3-23
 *@author soledad pisces
 *@fileName ModifyStudentAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.UnsupportedEncodingException;

import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.StudentDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class ModifyStudentAction {
	private StudentDomain studentDomain;
	private String id;
	private String message;
	private int pageNum;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String execute() throws UnsupportedEncodingException {
		
		if(this.id == null) {
			this.id = (String)ActionContext.getContext().getSession().get("idHere");
			this.pageNum = ((Integer)ActionContext.getContext().getSession().get("pageNums")).intValue();
		}
		
		StudentMessageDao studentDao = new StudentMessageDaoHibernateImpl();
		studentDomain = studentDao.findById(id);
		
		if(studentDomain == null){
			message = "<script>alert('更新失败')</script>";
		} else {
			message = "<script>alert('更新成功')</script>";
		}
		
		return "success";
	}

	public StudentDomain getStudentDomain() {
		return studentDomain;
	}

	public void setStudentDomain(StudentDomain studentDomain) {
		this.studentDomain = studentDomain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
