package smsplatform.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.record.formula.functions.Tdist;
import org.apache.struts2.ServletActionContext;

import smsplatform.dao.TBdUser;

public class AddUserAction {
	public String F_UserName;
	public TBdUser tBdUser;
	public String message;
	
	public String execute(){

		if ("".equals(F_UserName.trim()) || F_UserName == null) {
			return "fail";
		}

		tBdUser= new TBdUser();
		tBdUser.setFEmail("1033761115@qq.com");
		System.out.println("name="+F_UserName);
		/* Map<String,Object> map = new HashMap<String,Object>();
		
		             map.put("name", "99");
		       map.put("age","89");
		 
		             map.put("position", "ooo");
	
		
		             JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
		
		         String    result = json.toString();*/
		
		message = "hello word";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		try {
			response.getWriter().println(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	

}
