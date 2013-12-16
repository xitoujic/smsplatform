package smsplatform.action;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import smsplatform.dao.TBdMessagesend;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdUser;
import smsplatform.domain.Page;
import smsplatform.service.AdminService;

public class AdminAction {
     public   Page<TBdUser> userPage ;
     public   Page<TBdMessagesend> msgsendPage;
     public   Page<TBdMessagesendgroup> msgGrouPage;
     public   Page<TBdRechargeandconsumption> consumPage;
     public   List<TBdUser> tBdUsers;
     public   int usrID;
     public   int money;
     public   String result;
     public String findAllUser(){
    	 try {
    		
			 AdminService userService = new AdminService();
			 tBdUsers = userService.findAllUser();
		/*	 JSONObject json=new JSONObject(); 
			 json.accumulate("tBdUsers", tBdUsers);
			 
			 result = json.toString();
			 System.out.println(result);*/
			 
			     JsonConfig config = new JsonConfig();
			       config.setExcludes(new String[]{"TBdMessagesendgroups","TBdRechargeandconsumptions","TBdLogs"});//除去emps属性
			       result= JSONArray.fromObject(tBdUsers, config).toString();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
    	 return "success";
     }
     /**
      * 查询用户信息
      * @return
      */
     public String findUser(){
    	 try {
			 AdminService userService = new AdminService();
			 userPage.setRecords(userService.getScrollData(userPage.getMaxresult(), userPage.getCurrentpage()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
    	return "success";
     }
     /**
      * 用户充值（用户名，充值金额）
      * @return
      */
     public String recharge(){
    	 try {
    		 AdminService userService = new AdminService();
    		 userService.recharge(usrID, money);
    		 } catch (Exception e) {
    		 // TODO Auto-generated catch block
    		 e.printStackTrace();
    		 return "fail";
    	 }
    	 return "success";
     }
     
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
	public Page<TBdUser> getUserPage() {
		return userPage;
	}
	public void setUserPage(Page<TBdUser> userPage) {
		this.userPage = userPage;
	}
	public Page<TBdMessagesend> getMsgsendPage() {
		return msgsendPage;
	}
	public void setMsgsendPage(Page<TBdMessagesend> msgsendPage) {
		this.msgsendPage = msgsendPage;
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
	public List<TBdUser> gettBdUsers() {
		return tBdUsers;
	}
	public void settBdUsers(List<TBdUser> tBdUsers) {
		this.tBdUsers = tBdUsers;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
