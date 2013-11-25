/**
 *@time 2011-4-22
 *@author soledad pisces
 *@fileName ToStudentMessageAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.util.List;

import com.hanphon.recruit.dao.impl.Pagination;
import com.hanphon.recruit.dao.impl.PaginationHibernateUtil;
import com.hanphon.recruit.domain.ShowStudentDomain;

/**
 * @author soledad pisces
 * 
 */
public class ToStudentMessageAction {
	private int items;
	private int pageNum;
	private String category1;
	private String category2;
	private String status;

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

	private List<ShowStudentDomain> studentList;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<ShowStudentDomain> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<ShowStudentDomain> studentList) {
		this.studentList = studentList;
	}

	public String execute() {

		if (this.category1 == null && this.category2 == null) {
			this.category1 = "1";
			this.category2 = "";
		}

		if (this.category1 == "" && this.category2 == "") {
			this.category1 = "1";
		}

		if (this.status == null) {
			this.status = "1";
		}

		if (this.status == "") {
			this.status = "1";
		}

		if ("".equals(category2) && "1".equals(category1)) {// 普通
			Pagination pagination = new PaginationHibernateUtil(13, pageNum,
					"普通", this.status);
			this.items = pagination.getMaxPages();
			this.studentList = pagination.getList();
		}

		if ("".equals(category1) && "1".equals(category2)) {// 艺体
			Pagination pagination = new PaginationHibernateUtil(13, pageNum,
					"艺体", this.status);
			this.items = pagination.getMaxPages();

			this.studentList = pagination.getList();
		}

		if ("1".equals(category2) && "1".equals(category1)) {
			Pagination pagination = new PaginationHibernateUtil(13, pageNum,
					this.status);
			this.items = pagination.getMaxPages();

			this.studentList = pagination.getList();
		}
		return "success";
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

}
