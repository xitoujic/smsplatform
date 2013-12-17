package smsplatform.junit;

import java.util.List;

import org.junit.Test;

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
   
	@Test
	public void t2(){
		UserService userService = new UserService();
		List<TBdRechargeandconsumption> tBdRechargeandconsumption = userService.findAllRechargeConsume(47l);
		System.out.println( tBdRechargeandconsumption.size());
		
	}
	@Test
	public void t3(){
		 UserService userService = new UserService();
		 TBdMessagesendgroup tBdMessagesendgroup = new TBdMessagesendgroup();
		 tBdMessagesendgroup.setFSendGroupId(12l);
		 List<TBdMessagesend>  tBdMessagesends = userService.findallSendMsg(tBdMessagesendgroup);
		 System.out.println(tBdMessagesends.size());
		
	}
	@Test
	public void t4(){
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		TBdMessagesendgroup tBdMessagesendgroup =smsgGroupDao.findById(15l);
		System.out.println(tBdMessagesendgroup.getFGroupContent());
		System.out.println(tBdMessagesendgroup.getTBdMessagesends());
		System.out.println("nice");
		
	}
	
	@Test
	public void t5(){
		UserService userService = new UserService();
		List<TBdMessagesendgroup> tBdMessagesendgroups = userService.findallgroupMsg(47l);
		System.err.println(tBdMessagesendgroups.size());
	}
	
}
