package smsplatform.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdRechargeandconsumptionDAO;
import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;
import smsplatform.domain.PageView;

public class UserService {
	
	
	public List<TBdUser> getScrollData(){
		List<TBdUser> tBdUsers = new ArrayList<TBdUser>();
		TBdUserDAO tBdUserDAO= new TBdUserDAO();
		tBdUsers = tBdUserDAO.queryByPage(5, 2) ;
		
		System.out.println(tBdUserDAO.totalcount());
		return tBdUsers;
	}
	public List<TBdUser> getScrollData(int pagesize,int currrentPage){
		List<TBdUser> tBdUsers = new ArrayList<TBdUser>();
		TBdUserDAO tBdUserDAO= new TBdUserDAO();
		tBdUsers = tBdUserDAO.queryByPage(pagesize, currrentPage) ;
		
		System.out.println(tBdUserDAO.totalcount());
		return tBdUsers;
	}
	
	
	public boolean recharge(long usrID,int money){
		
		TBdRechargeandconsumptionDAO tBdRechargeandconsumptionDAO = new TBdRechargeandconsumptionDAO();
		
		TBdUserDAO tBdUserDAO= new TBdUserDAO();
		TBdUser  tBdUser = tBdUserDAO.findById(usrID);
		/**
		 * 第一次充值
		 */
		TBdRechargeandconsumption tBdRechargeandconsumption = tBdRechargeandconsumptionDAO.findLastResultById(usrID);
		if( tBdRechargeandconsumption == null){
			tBdRechargeandconsumption = new TBdRechargeandconsumption();
			tBdRechargeandconsumption.setTBdUser(tBdUser);
			tBdRechargeandconsumption.setFOperateTime(new Timestamp(System.currentTimeMillis()));
			tBdRechargeandconsumption.setFOperateType("消费");
			tBdRechargeandconsumptionDAO.save(tBdRechargeandconsumption);
		}
		
	/*	tBdRechargeandconsumption.setFOperateType("充值");
		
		tBdRechargeandconsumption.setFBeforeRechargeMoney(tBdRechargeandconsumption.getTBdUser().getFMoney());
		tBdRechargeandconsumption.setFBeforeRechargeNum(tBdRechargeandconsumption.getTBdUser().getFMessageNumber());
		tBdRechargeandconsumption.setFAfterRechargeMoney(tBdRechargeandconsumption.getFBeforeRechargeMoney()+money);
		tBdUser.setFMoney(tBdUser.getFMoney()+money);
		tBdUser.setFMessageNumber(new Double(tBdUser.getFMessageNumber()+money*1l/0.4).longValue());
		tBdRechargeandconsumption.setFAfterRechargeMoney(tBdUser.getFMoney()+money);
		tBdRechargeandconsumption.setFAfterRechargeNum(new Double(tBdUser.getFMessageNumber()+money*1l/0.4).longValue());
		tBdRechargeandconsumption.setFRcgAndCuptId(null);
		tBdRechargeandconsumption.setTBdUser(tBdUser);
		tBdRechargeandconsumptionDAO.save(tBdRechargeandconsumption);*/
		TBdRechargeandconsumption tBdRechargeandconsumption2 = new TBdRechargeandconsumption();
		tBdRechargeandconsumption2.setFOperateType("充值");
		
		tBdRechargeandconsumption2.setFBeforeRechargeMoney(tBdRechargeandconsumption.getTBdUser().getFMoney());
		tBdRechargeandconsumption2.setFBeforeRechargeNum(tBdRechargeandconsumption.getTBdUser().getFMessageNumber());
		//tBdRechargeandconsumption2.setFAfterRechargeMoney(tBdRechargeandconsumption.getFBeforeRechargeMoney()+money);
		
		tBdRechargeandconsumption2.setFAfterRechargeMoney(tBdUser.getFMoney()+money);
		tBdRechargeandconsumption2.setFAfterRechargeNum(new Double(tBdUser.getFMessageNumber()+money*1l/0.4).longValue());
		tBdRechargeandconsumption2.setFRcgAndCuptId(null);
		tBdRechargeandconsumption2.setFRechargeMoney(new Double(money));
		
		tBdRechargeandconsumption2.setFOperateTime(new Timestamp(System.currentTimeMillis()));
		tBdUser.setFMoney(tBdUser.getFMoney()+money);
		tBdUser.setFMessageNumber(new Double(tBdUser.getFMessageNumber()+money*1l/0.4).longValue());
		tBdRechargeandconsumption2.setTBdUser(tBdUser);
		tBdRechargeandconsumptionDAO.save(tBdRechargeandconsumption2);
		return true;
		
	}

}
