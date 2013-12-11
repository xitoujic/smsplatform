package smsplatform.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.opensymphony.xwork2.ActionContext;

import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdUser;
import smsplatform.domain.Page;
import smsplatform.service.UserService;

public class UserAction {
	  public   Page<TBdMessagesendgroup> msgGrouPage;
	  public   Page<TBdRechargeandconsumption> consumPage;
	  public   TBdMessagesendgroup tBdMessagesendgroup;
	  public  TBdUser tBdUser;
	  
	  
	  public String sendMsg(){
		  UserService userService = new UserService();
		  return userService.sendmsg(tBdMessagesendgroup);
	  }
	  
	  public String findMessagesendgroup(){
		 Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  UserService userService = new UserService();
		  userService.findMessagesendgroup(msgGrouPage,uid);
		  return "success";
	  }
	  
	  public String writeInfo(){
		  System.out.println("===");
		  TBdUser dBdUser = tBdUser;
		  System.out.println("用户名:"+tBdUser.getFUserFullName());
		  System.out.println("email:"+tBdUser.getFEmail());
		  System.out.println("tel:"+tBdUser.getFPhoneNumber());
		  UserService userService = new UserService();
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  if (userService.writeInfo(dBdUser, uid).equals("success")) {
			return "writeInfo";
		  }else {
			return "fail";
		}
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

	public Page<TBdMessagesendgroup> getMsgGrouPage() {
		return msgGrouPage;
	}

	public void setMsgGrouPage(Page<TBdMessagesendgroup> msgGrouPage) {
		this.msgGrouPage = msgGrouPage;
	}

	public Page<TBdRechargeandconsumption> getConsumPage() {
		return consumPage;
	}

	public void setConsumPage(Page<TBdRechargeandconsumption> consumPage) {
		this.consumPage = consumPage;
	}

	public TBdMessagesendgroup gettBdMessagesendgroup() {
		return tBdMessagesendgroup;
	}

	public void settBdMessagesendgroup(TBdMessagesendgroup tBdMessagesendgroup) {
		this.tBdMessagesendgroup = tBdMessagesendgroup;
	}

	public TBdUser gettBdUser() {
		return tBdUser;
	}

	public void settBdUser(TBdUser tBdUser) {
		this.tBdUser = tBdUser;
	}
	  
	

}
