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


public class teast {
	@Test
	public void test(){
		/*TBdUserDAO tBdUserDAO = new TBdUserDAO();
		Long idLong = 1l;
		TBdUser tBdUser =tBdUserDAO.findById(idLong);
		System.out.println(tBdUserDAO.findAll().size());*/
		
	/*//	UserDao userDao = new UserDao();
		TBdUser tBdUser = new TBdUser();
	//	tBdUser.setFSex(true);
		tBdUser.setFPassword("FPassword");
		tBdUser.setFUserFullName("FUserFullName");
		userDao.save(tBdUser);
		TBdUser tBdUser2 =userDao.findById(1l);
		System.out.println(tBdUser2.getFUserFullName());*/
		
	}
	
	@Test
	public void user(){
		UserAction action = new UserAction();
		action.findMessagesendgroup();
	}
	@Test
	public void da0(){
		SUserDao sUserDao = new SUserDao();
		System.out.println(sUserDao.findALL()+"nice::");
		sUserDao.findById(1l);
		List<TBdUser> tBdUsers = sUserDao.queryByPage(5, 2);
	}
	@Test
	public void dao(){
		SUserDao sUserDao = new SUserDao();
		System.out.println(sUserDao.findByProperty("FUserName", "nice").size());
	}
	@Test
	public void dao2(){
		SUserDao sUserDao = new SUserDao();
		List<TBdUser> list =
		sUserDao.queryByPage(4, 1, "FUserId", false);
		//List<TBdUser> list = sUserDao.findByProperty("FUserId", value, orderBY, ascORdesc)
		System.out.println(sUserDao.findByProperty("FUserName", "nice").size());
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
		AdminService userService = new AdminService();
		TBdUser tBdUser = new TBdUser();
		tBdUser.setFPassword("uu");
		tBdUser.setFUserName("hah");
        tBdUser.setFRole("普通用户");
		System.out.println(userService.addUser(tBdUser));;
	 //   userService.recharge(2l, 500);
		
	}
	
	@Test 
	 public void t(){
		AdminService userService = new AdminService();
		List<TBdUser> tBdUsers = userService.getScrollData(10, 2);
		int i = userService.getScrollData().size();
		//System.out.println(i+1);
	}
	@Test 
	public void update(){
		UserService userService = new UserService();
		TBdUser tBdUser = new TBdUser();
		tBdUser.setFUserId(1l);
		tBdUser.setFEmail("4255871115@qq.com");
		tBdUser.setFCompanyType("无锡四大");
		tBdUser.setFUpdateStatus("已修改");
		tBdUser.setFPhoneNumber("18952478547");
		tBdUser.setFCompanyType("ysdf");
		tBdUser.setFUserFullName("nice");
	    userService.update(tBdUser, 1l);
	
	 //   userService.recharge(2l, 500);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	 public void sendmsg(){
		UserService userService = new UserService();
		//userService.sendmsg(null);
		Page<TBdMessagesendgroup> page = new Page<TBdMessagesendgroup>();
		page.setMaxresult(4);
		page.setCurrentpage(1);
		Long uid = 1l;
		List<TBdMessagesendgroup> tBdMessagesendgroups =userService.findMessagesendgroup(page, uid);
		System.out.println(tBdMessagesendgroups.size());
	}
	@Test 
	public void findmsg(){
		UserService userService = new UserService();
		//userService.sendmsg(null);
		List<TBdMessagesendgroup> list =userService.findAllMsg(1l);
		System.out.println(list.size());
	}
	public String[] parsePhoneNum(String phone){
		
		return phone.split(",");
		
	}
	@Test
	public void testsplit(){
		String phoneString="18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672," +
				"18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672,18953768672";
		String [] niceStrings=parsePhoneNum(phoneString);
		for (int i = 0; i < niceStrings.length; i++) {
		System.out.println(niceStrings[i]);
	}
		System.out.println(parsePhoneNum(phoneString).length);
	}
   
}
