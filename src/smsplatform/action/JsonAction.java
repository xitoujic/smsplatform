package smsplatform.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private String result;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * ����ajax����
	 * @return SUCCESS
	 */
	public String excuteAjax(){
		
		try {
			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age")); 
			String position = request.getParameter("position");
		
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", name);
			map.put("age",age);
			map.put("position", position);
			
			JSONObject json = JSONObject.fromObject(map);
			result = json.toString();
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	
}
