/**
 *@time 2011-4-22
 *@author soledad pisces
 *@fileName NoticeItemAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class NoticeItemAction {
	private int item;

	public String execute() {
		System.out.println(item);
		ActionContext.getContext().getSession().put("item", item);
		return "success";
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

}
