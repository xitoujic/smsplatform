/**
 *@time 2011-4-23
 *@author soledad pisces
 *@fileName DeleteStudentMessgeAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.StudentDomain;

/**
 * @author soledad pisces
 * 
 */
public class DeleteStudentMessgeAction {
	private String id;
	private int pageNum;
	private String message;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute() {
		System.out.println(this.pageNum);
		StudentMessageDao dao = new StudentMessageDaoHibernateImpl();
		StudentDomain domain = dao.findById(id);
		boolean flag = dao.delete(domain);
		if (flag) {
			message = "<script>alert('删除成功')</script>";
			return "success";
		} else {
			message = "<script>alert('删除失败')</script>";
			return "fail";
		}

	}
}
