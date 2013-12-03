package smsplatform.service;

import java.util.ArrayList;
import java.util.List;

import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;
import smsplatform.domain.PageView;

public class UserService {
	
	
	public List<TBdUser> getScrollData(){
		List<TBdUser> tBdUsers = new ArrayList<TBdUser>();
		TBdUserDAO tBdUserDAO= new TBdUserDAO();
		tBdUsers = tBdUserDAO.queryByPage(10, 1) ;
		
		System.out.println(tBdUserDAO.totalcount());
		return tBdUsers;
	}

}
