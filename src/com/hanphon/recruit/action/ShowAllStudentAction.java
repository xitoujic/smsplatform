/**
 *@time 2011-3-21
 *@author soledad pisces
 *@fileName ShowAllStudentAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.hanphon.recruit.dao.impl.Pagination;
import com.hanphon.recruit.dao.impl.PaginationHibernateUtil;
import com.hanphon.recruit.domain.ShowStudentDomain;

/**
 * @author soledad pisces
 * 
 */
public class ShowAllStudentAction {
	private int items;
	private String category1;
	private String category2;
	private String status;
	private int pageNum;
	private int pageSize = 13;
	private List<ShowStudentDomain> studentList;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void execute() throws IOException {

		if (!"1".equals(category1)) {
			category1 = null;
		}

		if (!"1".equals(category2)) {
			category2 = null;
		}

//		HttpServletRequest request = ServletActionContext.getRequest();
//		if (request.getParameter("d-5475-p") == null) {
//			pageNum = 1;
//			ActionContext.getContext().getSession().put("pageNum", 1);
//		} else {
//			pageNum = Integer.parseInt(request.getParameter("d-5475-p"));
//			ActionContext.getContext().getSession().put("pageNum", pageNum);
//		}

		if (category1 == null && category2 == null) {
			message = "<msg>ERROR</msg>";
		} else {

			if (category2 == null && "1".equals(category1)) {// 普通

				Pagination pagination = new PaginationHibernateUtil(
						this.pageSize, pageNum, "普通", this.status);
				this.pageSize = pagination.getPageSize();
				this.items = pagination.getMaxElements();

				this.studentList = pagination.getList();

//				ActionContext.getContext().getSession().put("status",
//						this.status);
//				ActionContext.getContext().getSession().put("category1",
//						this.category1);
//				ActionContext.getContext().getSession().put("category2",
//						null);
				message = "<msg>SUCCESS</msg>";
			}

			if (category1 == null && "1".equals(category2)) {// 艺体

				Pagination pagination = new PaginationHibernateUtil(
						this.pageSize, pageNum, "艺体", this.status);
				this.pageSize = pagination.getPageSize();
				this.items = pagination.getMaxElements();

				this.studentList = pagination.getList();
//
//				ActionContext.getContext().getSession().put("status",
//						this.status);
//				ActionContext.getContext().getSession().put("category1", null);
//				ActionContext.getContext().getSession().put("category2",
//						this.category2);
				message = "<msg>SUCCESS</msg>";
			}

			if ("1".equals(category2) && "1".equals(category1)) {

				Pagination pagination = new PaginationHibernateUtil(
						this.pageSize, pageNum, this.status);
				this.pageSize = pagination.getPageSize();
				this.items = pagination.getMaxElements();

				this.studentList = pagination.getList();

//				ActionContext.getContext().getSession().put("status",
//						this.status);
//				ActionContext.getContext().getSession().put("category1",
//						this.category1);
//				ActionContext.getContext().getSession().put("category2",
//						this.category2);
				message = "<msg>SUCCESS</msg>";
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<ShowStudentDomain> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<ShowStudentDomain> studentList) {
		this.studentList = studentList;
	}


	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
