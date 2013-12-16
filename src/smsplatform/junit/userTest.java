package smsplatform.junit;

import java.util.List;

import org.junit.Test;

import smsplatform.action.AdminAction;
import smsplatform.action.UserAction;
import smsplatform.dao.Gender;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdRechargeandconsumptionDAO;
import smsplatform.dao.TBdUser;

import smsplatform.dao.impl.SUserDao;
import smsplatform.dao.impl.UserDao;
import smsplatform.domain.Page;
import smsplatform.service.AdminService;
import smsplatform.service.UserService;


public class userTest {
	@Test
	public void t1(){
		String phoneString="18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672," +
		"18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672";

		UserService userService = new UserService();
		TBdMessagesendgroup tBdMessagesendgroup = new TBdMessagesendgroup();
		tBdMessagesendgroup.setFGroupContent("2013 年圣诞节快乐！！！！！！");
		tBdMessagesendgroup.setFGroupPhones(phoneString);
		userService.sendmsg(tBdMessagesendgroup, 47l);
	}
   
}
