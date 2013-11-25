/**
 *@time 2011-4-23
 *@author soledad pisces
 *@fileName InsertScoreAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

/**
 * @author soledad pisces
 * 
 */
public class InsertScoreAction {
	private String id;

	public String execute() {
		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
