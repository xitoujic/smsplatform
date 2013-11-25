/**
 *@time 2011-3-19
 *@author soledad pisces
 *@fileName DownloadApplyAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import java.io.InputStream;

import org.jdom.JDOMException;

import com.hanphon.recruit.Utils.ApplyPdfCreate;
import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.StudentDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class DownloadApplyAction {
	private InputStream ipStream = null;
	private String fileName = null;

	public InputStream getDownloadFile() {
		return ipStream;
	}

	public String execute() throws JDOMException {
		
		StudentDomain studentDomain = null;
		StudentMessageDao dao = new StudentMessageDaoHibernateImpl();
		studentDomain = dao.findById((String)ActionContext.getContext().getSession().get("uid"));
		this.fileName = (String)ActionContext.getContext().getSession().get("userName");
		ApplyPdfCreate aPdfCreate = new ApplyPdfCreate(studentDomain);
		this.ipStream = aPdfCreate.getPdfStream();
		
		return "success";
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
