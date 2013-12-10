package smsplatform.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.opensymphony.xwork2.ActionContext;

import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.domain.Page;
import smsplatform.service.UserService;

public class UserAction {
	  public   Page<TBdMessagesendgroup> msgGrouPage;
	  public   Page<TBdRechargeandconsumption> consumPage;
	  public   TBdMessagesendgroup tBdMessagesendgroup;
	  
	  
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
	  
	

}
