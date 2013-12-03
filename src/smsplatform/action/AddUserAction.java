package smsplatform.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.record.formula.functions.Tdist;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;


import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;


public class AddUserAction {
	public String F_UserName;
	public String F_type;
	public String F_Password;
	public TBdUser tBdUser;
	public String message;
	public List<TBdUser> users =  new ArrayList<TBdUser>();
	
	public String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public List<TBdUser> getUsers() {
		return users;
	}
	public void setUsers(List<TBdUser> users) {
		this.users = users;
	}
	public String execute(){
	
		if ("".equals(F_UserName.trim()) || F_UserName == null) {
			return "fail";
		}

		if ("".equals(F_Password.trim()) || F_Password == null) {
			return "fail";
		}
		if ("".equals(F_type.trim()) || F_type == null) {
			return "fail";
		}


		tBdUser= new TBdUser();
		tBdUser.setFEmail("1033761115@qq.com");
		System.out.println("name="+F_UserName);

		System.out.println("password="+F_Password);
		System.out.println("type="+F_type);

		TBdUser transientInstance = new TBdUser();
		transientInstance.setFUserName(F_UserName.trim());
		transientInstance.setFPassword(F_Password.trim());
		transientInstance.setFRole(F_type);
		
		
		
		TBdUserDAO tBdUserDAO =  new TBdUserDAO();
		
		tBdUserDAO.save(transientInstance);
		
		System.out.println(tBdUserDAO.findAll().size()+"_____size__"+tBdUserDAO.totalcount());
		
        Map<String,Object> map = new HashMap<String,Object>();
/*
=======

		 Map<String,Object> map = new HashMap<String,Object>();

		/*
>>>>>>> bad950b492c8140d9290d31aa86e738ef23edec0
		TBdUserDAO tBdUserDAO = new TBdUserDAO();
		System.out.println(tBdUserDAO.findAll().size());*/
		/* Map<String,Object> map = new HashMap<String,Object>();
>>>>>>> cfd8233ab8a31099fdede8a1366f54262f312de5
		
		             map.put("name", "99");
		             map.put("age","89");
		 
		             map.put("position", "ooo");
	
		
		         //    JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
		
		       //   result = json.toString();
		
		//message = result;
		/*HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		try {
			response.getWriter().println(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		         /*  r1 = new ErrorCondition("张三", "4306821989021611", "L", "长度错误");  
		          ErrorCondition r2 = new ErrorCondition("李四", "430682198902191112","X", "校验错误");  
		          ErrorCondition r3 = new ErrorCondition("王五", "", "N", "身份证信息为空");  
		            
		          List<ErrorCondition> list = new ArrayList<ErrorCondition>();  */
		         TBdUser r1 = new TBdUser();r1.setFUserFullName("zhang san");
		         TBdUser r2 = new TBdUser();r2.setFUserFullName("zhang san2");
		         TBdUser r3 = new TBdUser();r3.setFUserFullName("zhang san3");
		        //  users.add();
		          users.add(r1);  
		          users.add(r2);  
		          users.add(r3);  
		            
		          //将list转化成JSON对象  
		        /*  JSONArray jsonArray = JSONArray.fromObject(users);  
		          HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);  
		          response.setCharacterEncoding("UTF-8");   
		          try {
					response.getWriter().print(jsonArray);
					//response.getWriter().print(json);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  */
		          JSONObject json=new JSONObject(); 
		          json.accumulate("user", users);
		          json.accumulate("map", map);
		          result = json.toString();
		System.out.println("*********");
		
		return "success";
	}

	public String getF_UserName() {
		return F_UserName;
	}

	public void setF_UserName(String fUserName) {
		F_UserName = fUserName;
	}

	public TBdUser gettBdUser() {
		return tBdUser;
	}

	public void settBdUser(TBdUser tBdUser) {
		this.tBdUser = tBdUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getF_type() {
		return F_type;
	}
	public void setF_type(String fType) {
		F_type = fType;
	}
	public String getF_Password() {
		return F_Password;
	}
	public void setF_Password(String fPassword) {
		F_Password = fPassword;
	}
	
	

}
