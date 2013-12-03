package smsplatform.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport implements ServletRequestAware{

	
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
	public String excute(){
		
		try {
			//��ȡ���
			String idString = (String)ActionContext
			.getContext().getSession().get("uid");
			
			//����ݴ洢��map���ת����json������ݣ�Ҳ�����Լ��ֶ�����json�������
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uid", idString);
			JSONObject json = JSONObject.fromObject(map);//��map����ת����json�������
			result = json.toString();//��result��ֵ�����ݸ�ҳ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String log(){
		
		try {
			//��ȡ���
			Integer idString = (Integer)ActionContext
			.getContext().getSession().get("uid");
			
			//����ݴ洢��map���ת����json������ݣ�Ҳ�����Լ��ֶ�����json�������
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uid", idString);
			JSONObject json = JSONObject.fromObject(map);//��map����ת����json�������
			result = json.toString();//��result��ֵ�����ݸ�ҳ��
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	
}
