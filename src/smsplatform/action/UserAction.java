package smsplatform.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import smsplatform.dao.TBdMessagesend;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdUser;
import smsplatform.dao.impl.SLogDao;
import smsplatform.domain.Page;
import smsplatform.service.AdminService;
import smsplatform.service.LogService;
import smsplatform.service.UserService;

public class UserAction {
	  public   Page<TBdMessagesendgroup> msgGrouPage;
	  public   Page<TBdRechargeandconsumption> consumPage;
	  public   TBdMessagesendgroup tBdMessagesendgroup;
	  public   List<TBdMessagesendgroup> tBdMessagesendgroups;
	  public List<TBdRechargeandconsumption> tBdRechargeandconsumptions;
	  public  List<TBdMessagesend> tBdMessagesends;  //查询发送短信
	  public  TBdUser tBdUser;

	  /**
	   * 查询每个分组每条发送短信状态及消息
	   * @return
	   */
      public String findallgroupMsg(){
    	  UserService userService = new UserService();
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  tBdMessagesendgroups = userService.findallgroupMsg(uid);
		  
		   LogService.getInstance().log(uid, "查询所有的用户短信组消息");
		  return "success";
      }
      
      
	  public String findallSendMsg(){
		  AdminService adminService = new AdminService();
		  tBdMessagesends = adminService.findallSendMsg(tBdMessagesendgroup);
		  return "success";
		  
	  }
	  
	  public String findRechargeComsumption(){
		  UserService userService = new UserService();
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  tBdRechargeandconsumptions = userService.findRechargeComsumption(uid);
		  return "success";
	  }
	  public String sendMsg(){
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  UserService userService = new UserService();
		  
		  return userService.sendmsg(tBdMessagesendgroup,uid);
	  }
	  
	  public String findMessagesendgroup(){
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  UserService userService = new UserService();
		  userService.findMessagesendgroup(msgGrouPage,uid);
		  return "success";
	  }
	  
	  public String writeInfo(){
		 // System.out.println("===");
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

	public List<TBdMessagesendgroup> gettBdMessagesendgroups() {
		return tBdMessagesendgroups;
	}

	public void settBdMessagesendgroups(
			List<TBdMessagesendgroup> tBdMessagesendgroups) {
		this.tBdMessagesendgroups = tBdMessagesendgroups;
	}

	public List<TBdMessagesend> gettBdMessagesends() {
		return tBdMessagesends;
	}

	public void settBdMessagesends(List<TBdMessagesend> tBdMessagesends) {
		this.tBdMessagesends = tBdMessagesends;
	}
	  
	

}
