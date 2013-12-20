/**
 *@time 2011-3-14
 *@author soledad pisces
 *@fileName LoginAction.java
 *@contract jiangguojian1990@qq.com
 */
package smsplatform.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;
import smsplatform.dao.impl.SUserDao;
import smsplatform.service.UserService;

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
	private TBdUser tBdUser;

	/*public String execute() throws IOException {
		ActionContext context = ActionContext.getContext();  
	    HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
	    HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);  
	 
				 String location = "http://jiangnanedu-pc:8080/recruit/";
				     String location = "http://baidu.com";
				   //  response.sendRedirect(location);
			//	    System.out.println(sendGet(location));;
				
			

	
	     String result = "";
	     try{
	      String urlName = location ;

	      URL U = new URL(urlName);
	      URLConnection connection = U.openConnection();
	      connection.connect();
	     
	      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      String line;
	      while ((line = in.readLine())!= null)
	      {
	       result += line;
	      }
	      in.close();   
	     }catch(Exception e){
	      System.out.println("没有结果！"+e);
	     }
	   System.out.println( result+"nice___________");

		return "success";

	}*/
	public String execute() throws IOException {
		if ("".equals(userName.trim()) || userName == null) {
			return "fail";
		}
		
		if ("".equals(password.trim()) || password == null) {
			return "fail";
		}
		
		SUserDao sUserDao = new SUserDao();
		TBdUser tBdUser = new TBdUser();
		tBdUser.setFUserName(userName.trim());
		List<TBdUser> tBdUser2 = sUserDao.findByName(tBdUser.getFUserName());
		if (tBdUser2.size() == 0) {
			return "fail";
		}
		
		TBdUser tBdUser_r = tBdUser2.get(0);
		
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
	
	public String update(){
		Long idLong = 
		(Long) ActionContext.getContext().getSession().get("uid");
		tBdUser.setFUpdateStatus("已修改");
		tBdUser.setFUserId(idLong);
		UserService userService = new UserService();
		userService.update(tBdUser,idLong);
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

	public TBdUser gettBdUser() {
		return tBdUser;
	}

	public void settBdUser(TBdUser tBdUser) {
		this.tBdUser = tBdUser;
	}

}
