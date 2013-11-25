/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName LogoutAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 *
 */
public class LogoutAction {
	public String execute() {
		ActionContext.getContext().getSession().remove("isLogin");
		ActionContext.getContext().getSession().remove("isStudent");
		ActionContext.getContext().getSession().remove("userName");
		ActionContext.getContext().getSession().remove("uid");
		ActionContext.getContext().getSession().remove("password");	
		return "success";
	}
}
