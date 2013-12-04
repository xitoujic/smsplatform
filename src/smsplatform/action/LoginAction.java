/**
 *@time 2011-3-14
 *@author soledad pisces
 *@fileName LoginAction.java
 *@contract jiangguojian1990@qq.com
 */
package smsplatform.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;

import com.hanphon.recruit.dao.RegisterMessageDao;
import com.hanphon.recruit.dao.impl.RegisterMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.RegisterMessageDomain;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author soledad pisces
 * 
 */
public class LoginAction {
	private String userName;
	private String password;

	public String execute() throws IOException {
		if ("".equals(userName.trim()) || userName == null) {
			return "fail";
		}

		if ("".equals(password.trim()) || password == null) {
			return "fail";
		}

		TBdUserDAO tBdUserDAO = new TBdUserDAO();
		TBdUser tBdUser = new TBdUser();
		tBdUser.setFUserName(userName.trim());
	
		if (tBdUserDAO.findByFUserName(tBdUser.getFUserName()).size() == 0) {
			return "fail";
		}
		
		TBdUser tBdUser_r = (TBdUser) tBdUserDAO.findByFUserName(tBdUser.getFUserName()).get(0);

		if (!tBdUser_r.getFPassword().equals(password.trim())
				|| tBdUser_r == null) {
			return "fail";
		}
		System.out.println(tBdUser_r.getFRole()+"++++++++++++");
		if (tBdUser_r.getFRole().equals("管理员")) {
			ActionContext.getContext().getSession().put("isAdmin", "Y");
		}else {
			ActionContext.getContext().getSession().put("isAdmin", "N");
		
		}

		ActionContext.getContext().getSession().put("password", password);
		ActionContext.getContext().getSession().put("isLogin", "yes");
		ActionContext.getContext().getSession().put("userName", userName);
		ActionContext.getContext().getSession().put("uid",
				tBdUser_r.getFUserId());

		return "success";

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
