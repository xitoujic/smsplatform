/**
 *@time 2011-4-19
 *@author soledad pisces
 *@fileName ToCheckedAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import com.hanphon.recruit.dao.CheckedResultDao;
import com.hanphon.recruit.dao.impl.CheckedReslutDaoHibernateImpl;
import com.hanphon.recruit.domain.CheckedResultDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class ToCheckedAction {

	private CheckedResultDomain checkedResultDomain;

	public String execute() {
		CheckedResultDao dao = new CheckedReslutDaoHibernateImpl();
		this.checkedResultDomain = dao.findById((String) ActionContext
				.getContext().getSession().get("uid"));

		if (this.checkedResultDomain == null
				|| this.checkedResultDomain.getUserAuditResult() == null) {
			this.checkedResultDomain.setUserAuditResult("您的申请表还未经过审核!请稍候！");
			return "fail";
		}

		this.checkedResultDomain.setUserAuditResult("恭喜！您的申请表已经通过审核!");

		return "suceess";
	}

	public CheckedResultDomain getCheckedResultDomain() {
		return checkedResultDomain;
	}

	public void setCheckedResultDomain(CheckedResultDomain checkedResultDomain) {
		this.checkedResultDomain = checkedResultDomain;
	}

}
