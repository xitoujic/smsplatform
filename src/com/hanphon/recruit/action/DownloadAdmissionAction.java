/**
 *@time 2011-3-19
 *@author soledad pisces
 *@fileName DownloadAdmissionAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

/**
 * @author soledad pisces
 * 
 */
public class DownloadAdmissionAction {
	public InputStream getDownloadFile() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/download/admission.doc");
	}

	public String execute() {
		return "success";
	}
}
