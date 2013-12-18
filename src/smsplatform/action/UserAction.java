package smsplatform.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

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
	 /* public   Page<TBdMessagesendgroup> msgGrouPage;
	  public   Page<TBdRechargeandconsumption> consumPage;*/
	  public   TBdMessagesendgroup tBdMessagesendgroup;
	  public   List<TBdMessagesendgroup> tBdMessagesendgroups;
	  public  List<TBdRechargeandconsumption> tBdRechargeandconsumptions;
	  public  List<TBdMessagesend> tBdMessagesends;  //查询发送短信
	  public  TBdUser tBdUser;
	  public String result;
      
	  
	  public static String msg ="1";
	  public static  JSONObject json=new JSONObject(); 
	  public static  JsonConfig config = new JsonConfig();
	  /**
	   * 查询每个分组每条发送短信状态及消息
	   * @return
	   */
      @SuppressWarnings("unchecked")
	public String findallgroupMsg(){
    	
    	  UserService userService = new UserService();
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  try {
			tBdMessagesendgroups = userService.findallgroupMsg(uid);
			
			config.setExcludes(new String[]{"TBdMessagesends","TBdMessagesendgroups","TBdRechargeandconsumptions","TBdLogs","handler","hibernateLazyInitializer"});
            result=JSONArray.fromObject(tBdMessagesendgroups.toArray(), config).toString();
			// json.accumulate("tBdMessagesendgroups", tBdMessagesendgroups);
			// result= json.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="0";
			result = json.fromObject(msg).toString();
			return "fail";
		}
	     


      //    result=json.fromObject(msg).toString()+ JSONArray.fromObject(tBdMessagesendgroups, config).toString();
		 
	      LogService.getInstance().log(uid, "查询用户所有的短信组消息");
		  return "success";
      }
      
      
	  public String findallSendMsg(){
		  
		  AdminService adminService = new AdminService();
		  try {
			tBdMessagesends = adminService.findallSendMsg(tBdMessagesendgroup);
			  config.setExcludes(new String[]{"TBdMessagesendgroup"});//除去emps属性
			//  json.fromObject(msg).toString();
				 result=JSONArray.fromObject(tBdMessagesends, config).toString();
				 
				 
		} catch (Exception e) {
			e.printStackTrace();
			msg="0";
			result = json.fromObject(msg).toString();
			 Long uid = (Long) ActionContext.getContext().getSession().get("uid");
			 LogService.getInstance().log(uid, "查询所有短信组"+tBdMessagesendgroup.getFSendGroupId()+"消息");
			return "fail";
		}
		
		 return "success";
		  
	  }
	  
	  public String findRechargeComsumption(){
		  UserService userService = new UserService();
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  try {
			tBdRechargeandconsumptions = userService.findRechargeComsumption(uid);
		} catch (Exception e) {
			e.printStackTrace();
			msg="0";
			result = json.fromObject(msg).toString();
			return "fail";
		}
		 result=json.fromObject(msg).toString()+ JSONArray.fromObject(tBdRechargeandconsumptions, config).toString();
		 LogService.getInstance().log(uid, "查询所有充值消费记录");
		 return "success";
	  }
	  public String sendMsg(){
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  UserService userService = new UserService();
		  try {
			userService.sendmsg(tBdMessagesendgroup,uid);
		} catch (Exception e) {
			e.printStackTrace();
			msg="0";
			result = json.fromObject(msg).toString();
			return "fail";
		}
		  result=json.fromObject(msg).toString();
		  LogService.getInstance().log(uid, "发送消息"+tBdMessagesendgroup.getFGroupContent()+tBdMessagesendgroup.getFGroupPhones());
		  return "success";
	  }
	  
	/*  public String findMessagesendgroup(){
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  UserService userService = new UserService();
		  userService.findMessagesendgroup(msgGrouPage,uid);
		  return "success";
	  }*/
	  
	  public String writeInfo(){
		 // System.out.println("===");
		  TBdUser dBdUser = tBdUser;
		  System.out.println("用户名:"+tBdUser.getFUserFullName());
		  System.out.println("email:"+tBdUser.getFEmail());
		  System.out.println("tel:"+tBdUser.getFPhoneNumber());
		  UserService userService = new UserService();
		  Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		  if (userService.writeInfo(dBdUser, uid).equals("success")) {
			LogService.getInstance().log(uid,"更新个人信息");
			return "writeInfo";
		  }else {
			return "fail";
		}
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

	/*public Page<TBdMessagesendgroup> getMsgGrouPage() {
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
	}*/

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


	public List<TBdRechargeandconsumption> gettBdRechargeandconsumptions() {
		return tBdRechargeandconsumptions;
	}


	public void settBdRechargeandconsumptions(
			List<TBdRechargeandconsumption> tBdRechargeandconsumptions) {
		this.tBdRechargeandconsumptions = tBdRechargeandconsumptions;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}
	
	  
	

}
