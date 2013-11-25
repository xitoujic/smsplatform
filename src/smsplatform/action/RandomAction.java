package smsplatform.action ;

import java.io.ByteArrayInputStream;

import smsplatform.util.RandomNumUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RandomAction extends ActionSupport{    
private ByteArrayInputStream inputStream;    
public String execute() throws Exception{    
	RandomNumUtil rdnu=RandomNumUtil.Instance();    
	this.setInputStream(rdnu.getImage());//ȡ�ô�������ַ��ͼƬ    
	ActionContext.getContext().getSession().put("sessionCode", rdnu.getString());//ȡ������ַ����HttpSession    
	return SUCCESS;    
	}    
	public void setInputStream(ByteArrayInputStream inputStream) {    
	this.inputStream = inputStream;    
	}    
	public ByteArrayInputStream getInputStream() {    
	return inputStream;    
}   
}  
