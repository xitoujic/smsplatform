/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName StudentDomain.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.domain;


/**
 * @author soledad pisces
 * 
 */
public class CheckedResultDomain {
	private String userId;// 主键
	private String userAuditResult;// 用户审核结果

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAuditResult() {
		return userAuditResult;
	}

	public void setUserAuditResult(String userAuditResult) {
		this.userAuditResult = userAuditResult;
	}

}
