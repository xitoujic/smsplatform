/**
 *@time 2011-3-14
 *@author soledad pisces
 *@fileName LoginAction.java
 *@contract jiangguojian1990@qq.com
 */
package smsplatform.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.Template;

import smsplatform.dao.UserDomainDAO;
import smsplatform.util.EmailSender;

import com.hanphon.recruit.dao.RegisterMessageDao;
import com.hanphon.recruit.dao.impl.RegisterMessageDaoHibernateImpl;
import com.hanphon.recruit.domain.RegisterMessageDomain;
import com.opensymphony.xwork2.ActionContext;


/**
 * @author soledad pisces
 * 
 */
public class findpasswordAction {
	private String userName;
	private String password;
	private String code;   
 

	public String apply() throws IOException {
		if ("".equals(userName.trim()) || userName == null) {
			return "fail";
		}

		/*if ("".equals(password.trim()) || password == null) {
			return "fail";
		}*/
		System.out.println("name="+userName);
		String content ="<a target=\"_blank\" href=\"http://jiangnanedu-pc:8080/recruit/pages/findpassword_apply_Action?userName="+this.getUserName()+"\">"
		                 +"http://jiangnanedu-pc:8080/recruit/pages/findpassword_apply_Action?userName="+this.getUserName()
		                 +"	</a>";
		ActionContext.getContext().getSession().put("userName", userName);
	    EmailSender.send(new String[]{"xitoujicai@gmail.com","1033761115@qq.com"}, "邮件测试xxysd", content,null , "text/html");
	    /*Template template =null;
		try {
			template = Velocity.getTemplate("mailContent.vm");
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VelocityContext context = new VelocityContext();
		context.put("username", buyer.getUsername());
		context.put("validateCode", MD5.MD5Encode(buyer.getUsername()+ buyer.getPassword()));
		StringWriter writer = new StringWriter(); 
		template.merge(context, writer);
		String content2 = writer.toString();
		System.out.println(content2);*/
		return "success";
		
	}
		public String execute() throws IOException {
			if ("".equals(userName.trim()) || userName == null) {
				return "fail";
			}
			
			/*if ("".equals(password.trim()) || password == null) {
			return "fail";
		}*/
			System.out.println("name="+userName);
			ActionContext.getContext().getSession().put("userName", userName);
			return "success";
		
		
		
		
		/*UserDomainDAO userDomainDAO  = new UserDomainDAO();
		
		System.out.println("size:"+userDomainDAO.findAll().size());
		System.out.println(userDomainDAO.getCount());;
		
		
		
		String sessionCode=(String)(ActionContext.getContext().getSession().get("sessionCode"));    
	    if(sessionCode.equals(this.getCode())) {    
	    	System.out.println("验证码通过");
	        return "success";   
	      }else{   
	    	  System.out.println("验证码不通过");
	           return "fail";   
	        } */
		
	//	return "success";

		/*RegisterMessageDao<RegisterMessageDomain, String> dao = new RegisterMessageDaoHibernateImpl();

		String[] retValString = dao.findByEmail(this.userName.trim());

		if (retValString == null) {
			System.out.println("Reject You Login In The System");
			return "fail";
		}

		if (!retValString[0].equals(this.password)) {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;");
			PrintWriter out = response.getWriter();
			out.print("error password");
			out.flush();
			out.close();

			ActionContext.getContext().getSession().put("isLogin", "no");

			return "fail";
		} else {
			if (retValString[1].equals("Y")) {
				ActionContext.getContext().getSession().put("isStudent", "Y");
			} else {
				ActionContext.getContext().getSession().put("isStudent", "N");
			}

			ActionContext.getContext().getSession().put("uid", retValString[2]);
			ActionContext.getContext().getSession().put("password", password);
			ActionContext.getContext().getSession().put("isLogin", "yes");
			ActionContext.getContext().getSession().put("userName", userName);
			return "success";
		}*/

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
	
	public String getCode() {   
		return code;   
	}   
	public void setCode(String code) {   
	this.code = code;   
	}  

}
