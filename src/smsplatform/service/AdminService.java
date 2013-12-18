package smsplatform.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdRechargeandconsumptionDAO;
import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;
import smsplatform.dao.impl.SRechargeConsumptionDao;
import smsplatform.dao.impl.SUserDao;
import smsplatform.dao.impl.SmsgGroupDao;
import smsplatform.dao.impl.SmsgsendDao;
import smsplatform.domain.PageView;

public class AdminService {
	public static double price = 0.4;
	
	public List<TBdUser> getScrollData(){
		List<TBdUser> tBdUsers = new ArrayList<TBdUser>();
		TBdUserDAO tBdUserDAO= new TBdUserDAO();
		tBdUsers = tBdUserDAO.queryByPage(5, 2) ;
		
		System.out.println(tBdUserDAO.totalcount());
		return tBdUsers;
	}
	public List findallgroupMsg(){
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		return smsgGroupDao.findALLObject();
	}
	
	public List findallSendMsg(TBdMessagesendgroup tBdMessagesendgroup){
		
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		SmsgsendDao smsgsendDao = new SmsgsendDao();
		
		return smsgsendDao.findByProperty("TBdMessagesendgroup",tBdMessagesendgroup);
	}
	
	
	public List<TBdUser> getScrollData(int pagesize,int currrentPage){
		List<TBdUser> tBdUsers = new ArrayList<TBdUser>();
//		TBdUserDAO tBdUserDAO= new TBdUserDAO();
//		tBdUsers = tBdUserDAO.queryByPage(pagesize, currrentPage) ;
//	
		SUserDao sUserDao = new SUserDao();
		tBdUsers = sUserDao.queryByPage(pagesize, currrentPage);
	//	System.out.println(tBdUserDAO.totalcount());
		return tBdUsers;
	}
	
	public String addUser(TBdUser tBdUser){
		try {
			SUserDao sUserDao = new SUserDao();
			if (sUserDao.findByName(tBdUser.getFUserName()).size() > 0) {
				return "exist";
			}
			SRechargeConsumptionDao sRechargeConsumptionDao = new SRechargeConsumptionDao();
			sUserDao.save(tBdUser);
			TBdRechargeandconsumption tBdRechargeandconsumption = new TBdRechargeandconsumption();
			tBdRechargeandconsumption.setTBdUser(tBdUser);
			sRechargeConsumptionDao.save(tBdRechargeandconsumption);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		
		
		return "success";
		
	}
	
	public boolean recharge(long usrID,int money){
		
	
		SRechargeConsumptionDao sRechargeConsumptionDao = new SRechargeConsumptionDao();
		SUserDao sUserDao = new SUserDao();
		TBdUser  tBdUser =  sUserDao.findById(usrID);
		TBdRechargeandconsumption tBdRechargeandconsumption2 = new TBdRechargeandconsumption();
		tBdRechargeandconsumption2.setFOperateType("充值");
		tBdRechargeandconsumption2.setFBeforeRechargeMoney(tBdUser.getFMoney());
		tBdRechargeandconsumption2.setFBeforeRechargeNum(tBdUser.getFMessageNumber());
		
	    tBdRechargeandconsumption2.setFAfterRechargeMoney(tBdUser.getFMoney()+money);
		tBdRechargeandconsumption2.setFAfterRechargeNum(new Double(tBdUser.getFMessageNumber()+money*1l/price).longValue());
	
		tBdRechargeandconsumption2.setFRechargeMoney(new Double(money));
		
		//tBdRechargeandconsumption2.setFOperateTime(new Timestamp(System.currentTimeMillis()));
		
		tBdUser.setFMoney(tBdUser.getFMoney()+money);
		tBdUser.setFMessageNumber(new Double(tBdUser.getFMessageNumber()+money*1l/price).longValue());
		
		tBdRechargeandconsumption2.setTBdUser(tBdUser);
		tBdUser.setFUpdateTime(new Timestamp(System.currentTimeMillis()));
		sUserDao.update(tBdUser);
		sRechargeConsumptionDao.save(tBdRechargeandconsumption2);
		return true;
		
	}
/*	public boolean recharge(long usrID,int money){
		
		
		SRechargeConsumptionDao sRechargeConsumptionDao = new SRechargeConsumptionDao();
		SUserDao sUserDao = new SUserDao();
		TBdUser  tBdUser =  sUserDao.findById(usrID);
		TBdRechargeandconsumption tBdRechargeandconsumption = sRechargeConsumptionDao.findLastResultById(usrID);
		
		TBdRechargeandconsumption tBdRechargeandconsumption2 = new TBdRechargeandconsumption();
		tBdRechargeandconsumption2.setFOperateType("充值");
		tBdRechargeandconsumption2.setFBeforeRechargeMoney(tBdRechargeandconsumption.getTBdUser().getFMoney());
		tBdRechargeandconsumption2.setFBeforeRechargeNum(tBdRechargeandconsumption.getTBdUser().getFMessageNumber());
		tBdRechargeandconsumption2.setFAfterRechargeMoney(tBdUser.getFMoney()+money);
		tBdRechargeandconsumption2.setFAfterRechargeNum(new Double(tBdUser.getFMessageNumber()+money*1l/price).longValue());
		tBdRechargeandconsumption2.setFRcgAndCuptId(null);
		tBdRechargeandconsumption2.setFRechargeMoney(new Double(money));
		
		tBdRechargeandconsumption2.setFOperateTime(new Timestamp(System.currentTimeMillis()));
		
		tBdUser.setFMoney(tBdUser.getFMoney()+money);
		tBdUser.setFMessageNumber(new Double(tBdUser.getFMessageNumber()+money*1l/price).longValue());
		
		tBdRechargeandconsumption2.setTBdUser(tBdUser);
		
		sRechargeConsumptionDao.save(tBdRechargeandconsumption2);
		return true;
		
	}
*/	
	
	/**
	 * 查看所有的用户信息
	 * @return
	 */
	public List findAllUser(){
		SUserDao sUserDao = new SUserDao();
		return sUserDao.findALLObject();
		
	}
	
	public List findAllRechargeConsumeByUid(Long uid){
        SRechargeConsumptionDao sRechargeConsumptionDao = new SRechargeConsumptionDao();
		return sRechargeConsumptionDao.findByProperty("TBdUser.FUserId", uid);
	}
	
	public  List findAllsendMSGByUid(Long uid){
		
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		return smsgGroupDao.findByProperty("FSendGroupId",uid);
	}

}
