package smsplatform.junit;

import org.junit.Test;

import smsplatform.dao.Gender;
import smsplatform.dao.TBdUser;

import smsplatform.dao.impl.UserDao;
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
	 public void t(){
		UserService userService = new UserService();
		int i = userService.getScrollData().size();
		System.out.println(i+1);
	}

}
