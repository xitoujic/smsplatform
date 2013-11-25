/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName MessageFillAction.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.action;

import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.dao.impl.StudentMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.StudentDomain;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author soledad pisces
 * 
 */
@SuppressWarnings("serial")
public class MessageFillAction extends ActionSupport{
	private StudentDomain studentDomain;
	private String messageWarnning;
	
	public String execute(){
		if(studentDomain!=null){
			StudentMessageDao dao = new StudentMessageDaoHibernateImpl();
			
			studentDomain.setUserEmail((String)ActionContext.getContext().getSession().get("userName"));
			studentDomain.setUserPassword((String)ActionContext.getContext().getSession().get("password"));
			studentDomain.setIsStudent((String)ActionContext.getContext().getSession().get("isStudent"));
			studentDomain.setOnStatus("3");
			studentDomain.setUserId((String)ActionContext.getContext().getSession().get("uid"));
			
			Boolean retValue = dao.update(studentDomain);
			
			ActionContext.getContext().getSession().put("studentDomain", studentDomain);
			
			if (retValue == true) {
				return "success";
			}else{
				this.messageWarnning = "Error!studentDomain存储出错!";
				return "message";
			}	
		}
		this.messageWarnning = "Error!studentDomain对象为空";
		return "message";
	}

	public StudentDomain getStudentDomain() {
		return studentDomain;
	}

	public void setStudentDomain(StudentDomain studentDomain) {
		this.studentDomain = studentDomain;
	}

	public String getMessageWarnning() {
		return messageWarnning;
	}

	public void setMessageWarnning(String messageWarnning) {
		this.messageWarnning = messageWarnning;
	}

	@Override
	public void validate() {
	}


}
