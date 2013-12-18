package smsplatform.junit;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import smsplatform.action.AdminAction;
import smsplatform.action.UserAction;
import smsplatform.dao.Gender;
import smsplatform.dao.TBdMessagesend;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdRechargeandconsumptionDAO;
import smsplatform.dao.TBdUser;

import smsplatform.dao.impl.SUserDao;
import smsplatform.dao.impl.SmsgGroupDao;
import smsplatform.dao.impl.UserDao;
import smsplatform.domain.Page;
import smsplatform.service.AdminService;
import smsplatform.service.UserService;


public class adminTest {
	@Test
	public void t1(){
		AdminService adminService = new AdminService();
		adminService.recharge(47l, 100);
		
	}
	
	
}
