package smsplatform.junit;

import java.util.List;

import org.junit.Test;

import smsplatform.action.AdminAction;
import smsplatform.dao.Gender;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdRechargeandconsumptionDAO;
import smsplatform.dao.TBdUser;

import smsplatform.dao.impl.UserDao;
import smsplatform.domain.Page;
import smsplatform.service.UserService;

public class teast {
	@Test
	public void test(){
		/*TBdUserDAO tBdUserDAO = new TBdUserDAO();
		Long idLong = 1l;
		TBdUser tBdUser =tBdUserDAO.findById(idLong);
		System.out.println(tBdUserDAO.findAll().size());*/
		
		UserDao userDao = new UserDao();
		TBdUser tBdUser = new TBdUser();
	//	tBdUser.setFSex(true);
		tBdUser.setFPassword("FPassword");
		tBdUser.setFUserFullName("FUserFullName");
		userDao.save(tBdUser);
		TBdUser tBdUser2 =userDao.findById(1l);
		System.out.println(tBdUser2.getFUserFullName());
		
	}
	@Test
	public void add(){
		AdminAction action = new AdminAction();
		action.setUserPage(new Page<TBdUser>());
		action.findUser();
	}
	@Test
	public void ddd(){
		TBdRechargeandconsumptionDAO tBdRechargeandconsumptionDAO = new TBdRechargeandconsumptionDAO();
		TBdRechargeandconsumption tBdRechargeandconsumption = tBdRechargeandconsumptionDAO.findLastResultById(4l);
		
	}
	@Test
	public void ddda(){
		UserService userService = new UserService();
		userService.recharge(2l, 500);
		
	}
	
	@Test 
	 public void t(){
		UserService userService = new UserService();
		List<TBdUser> tBdUsers = userService.getScrollData();
		int i = userService.getScrollData().size();
		System.out.println(i+1);
	}
	
	

}
