/**
 *@time 2011-3-22
 *@author soledad pisces
 *@fileName ShowStudentDomain.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.domain;

/**
 * @author soledad pisces
 * 
 */
public class ShowStudentDomain {
	private String userId;// 主键
	private String userEmail;
	private String onStatus;// 用户进行填表的状态
	private String userCategory;// 选报类型
	private String userName;
	private String userAuditResult;
	private String userSex;
	private String userBirthday;
	private String userNation;// 民族
	private String isStudent;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getOnStatus() {
		return onStatus;
	}

	public void setOnStatus(String onStatus) {
		this.onStatus = onStatus;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserNation() {
		return userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

	public String getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(String isStudent) {
		this.isStudent = isStudent;
	}

	public String getUserAuditResult() {
		return userAuditResult;
	}

	public void setUserAuditResult(String userAuditResult) {
		this.userAuditResult = userAuditResult;
	}
}
