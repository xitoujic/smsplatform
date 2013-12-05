package smsplatform.action;

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
     public   int usrID;
     public   int money;
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

}
