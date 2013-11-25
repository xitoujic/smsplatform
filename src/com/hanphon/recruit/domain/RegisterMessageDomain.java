/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName RegisterMessageDto.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.domain;

/**
 * @author soledad pisces
 * 
 */
public class RegisterMessageDomain {
	private String userId;// 主键
	private String isStudent;
	private String userEmail;
	private String onStatus;// 用户进行填表的状态
	private String userPassword;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIsStudent() {
		return isStudent;
	}

	public void setIsStudent(String isStudent) {
		this.isStudent = isStudent;
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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
