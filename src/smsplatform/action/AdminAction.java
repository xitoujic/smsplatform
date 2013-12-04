package smsplatform.action;

import smsplatform.dao.TBdMessagesend;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdUser;
import smsplatform.domain.Page;

public class AdminAction {
     public   Page<TBdUser> userPage ;
     public   Page<TBdMessagesend> msgsendPage;
     public   Page<TBdMessagesendgroup> msgGrouPage;
     public   Page<TBdRechargeandconsumption> consumPage;
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
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
