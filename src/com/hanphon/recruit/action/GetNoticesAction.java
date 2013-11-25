/**
 *@time 2011-4-20
 *@author soledad pisces
 *@fileName GetNoticesAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.util.List;

import com.hanphon.recruit.dao.NoticeDao;
import com.hanphon.recruit.dao.impl.NoticeDaoHibernateImpl;
import com.hanphon.recruit.domain.NoticeDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class GetNoticesAction {
	private List<NoticeDomain> list;

	public String execute() {
		NoticeDao dao = new NoticeDaoHibernateImpl();
		list = dao.getAll();
		ActionContext.getContext().getSession().put("list", this.list);
		return "success";
	}

	public List<NoticeDomain> getList() {
		return list;
	}

	public void setList(List<NoticeDomain> list) {
		this.list = list;
	}
}
