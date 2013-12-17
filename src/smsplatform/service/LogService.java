package smsplatform.service;

import smsplatform.dao.TBdLog;
import smsplatform.dao.TBdUser;
import smsplatform.dao.impl.SLogDao;
import smsplatform.dao.impl.SUserDao;

public class LogService {
	 public static LogService instance = null;
	 public static SLogDao sLogDao = SLogDao.getInstance();
	   public static LogService getInstance(){
		   if (instance == null) {
			instance = new LogService();
			System.out.println("log初始化========");
		} else {
	       System.out.println("log 单例---");
		}
		   return instance;
	   }
	   
	   public void log(Long uid,String operate){
		   TBdLog tBdLog = new TBdLog();
		   TBdUser tBdUser = new TBdUser();
		   tBdUser.setFUserId(uid);
		   tBdLog.setTBdUser(tBdUser);
		   tBdLog.setFOperate(operate);
		   sLogDao.save(tBdLog);
	   }
	   public void log(Long uid,Long UserID,String operate){
		   TBdLog tBdLog = new TBdLog();
		   TBdUser tBdUser = new TBdUser();
		   SUserDao sUserDao = new SUserDao();
		   TBdUser tBdUser2 = sUserDao.findById(UserID);
		  
		   tBdUser.setFUserId(uid);
		   
		   tBdLog.setTBdUser(tBdUser);
		   
		   if (operate.contains("?")) {
			operate.replace("?", "用户名："+tBdUser2.getFUserFullName()+"登陆名："+tBdUser2.getFUserName());
		}
		   tBdLog.setFOperate(operate);
		   sLogDao.save(tBdLog);
	   }
}
