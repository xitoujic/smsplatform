package smsplatform.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Success;

import smsplatform.dao.TBdMessagesend;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdMessagesendgroupDAO;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;
import smsplatform.dao.impl.SRechargeConsumptionDao;
import smsplatform.dao.impl.SUserDao;
import smsplatform.dao.impl.SmsgGroupDao;
import smsplatform.dao.impl.SmsgsendDao;
import smsplatform.domain.Page;

public class UserService {
	public static double price = 0.4;
	public TBdMessagesend tBdMessagesend;
	public TBdMessagesendgroup tBdMessagesendgroup ;
	
	
	public List findallSendMsg(TBdMessagesendgroup tBdMessagesendgroup){
		
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		SmsgsendDao smsgsendDao = new SmsgsendDao();
		
		return smsgsendDao.findByProperty("TBdMessagesendgroup",tBdMessagesendgroup);
	}
	public  List findallgroupMsg(Long uid){
		TBdUser tBdUser = new TBdUser();
		tBdUser.setFUserId(uid);
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		  LogService.getInstance().log(uid, "查询所有的用户短信组消息");
		  LogService.getInstance().log(uid, "修改个人消息");
		return smsgGroupDao.findByProperty("TBdUser", tBdUser);
		
	}
	/**
	 * 用户添加个人信息
	 * @param tBdUser
	 * @param id
	 * @return
	 */
	public String update(TBdUser tBdUser,Long id){
		try {
			SUserDao sUserDao = new SUserDao();
			TBdUser tBdUser2 = sUserDao.findById(id);
		    tBdUser2.setFUserId(tBdUser.getFUserId());
			tBdUser2.setFPhoneNumber(tBdUser.getFPhoneNumber());
			tBdUser2.setFEmail(tBdUser.getFEmail());
			tBdUser2.setFUserFullName(tBdUser.getFUserFullName());
			tBdUser2.setFCompanyType(tBdUser.getFCompanyType());
			tBdUser2.setFSignature(tBdUser.getFSignature());
	    	sUserDao.update(tBdUser2);
	    	LogService.getInstance().log(id, "修改个人消息");
		} catch (Exception e) {
		    e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	 public List findRechargeComsumption(Long uid){
		SRechargeConsumptionDao sRechargeConsumptionDao = new SRechargeConsumptionDao();
		
		SUserDao sUserDao = new SUserDao();
		TBdUser tBdUser = sUserDao.findById(uid);
		return sRechargeConsumptionDao.findByProperty("TBdUser", tBdUser);
	 }
	 public List findMessagesendgroup(Page<TBdMessagesendgroup> page,Long uid){
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		//smsgGroupDao.queryByPage(page.getMaxresult(), page.getCurrentpage(), orderBY, ascORdesc)
	   return  smsgGroupDao.queryPageByProperty(page.getMaxresult(), page.getCurrentpage(), "FSendGroupId", false, "TBdUser.FUserId",uid );
	     
	 }
	 /**
	  * 查询所有的发送消息记录
	  * @param uid
	  * @return
	  */
	public  List  findAllMsg(Long uid){
		SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
		return smsgGroupDao.findByProperty("TBdUser.FUserId", uid);
	}
	/**
	 * 查询所有的消费、充值记录
	 * @param uid
	 * @return
	 */
	public  List  findAllRechargeConsume(Long uid){
		SRechargeConsumptionDao sRechargeConsumptionDao = new SRechargeConsumptionDao();
		
		return sRechargeConsumptionDao.findByProperty("TBdUser.FUserId", uid);
	}
	/**
	 * 查询剩余短信条数
	 * @param uid
	 * @return
	 */
	public Long findReleveMsgNumber(Long uid){
		SUserDao sUserDao = new SUserDao();
		return sUserDao.findById(uid).getFMessageNumber();
	}
	public void msgSend(String [] phones,TBdUser tBdUser,TBdMessagesend tBdMessagesend){
	//	tBdMessagesend.setTBdMessagesendgroup(TBdMessagesendgroup)
		SmsgsendDao smsgsendDao = new SmsgsendDao();
		for (int i = 0; i < phones.length; i++) {
			tBdMessagesend.setFSendNumber(phones[i]);
			smsgsendDao.save(tBdMessagesend);
		}
	}	
	public String sendmsg(TBdMessagesendgroup tBdMessagesendgroup,Long uid){
		try {
			TBdMessagesend tBdMessagesend = new TBdMessagesend();
			TBdUser tBdUser = new TBdUser();
			SmsgGroupDao smsgGroupDao = new SmsgGroupDao();
			SUserDao sUserDao = new SUserDao();
			SRechargeConsumptionDao sRechargeConsumptionDao = new SRechargeConsumptionDao();
			TBdRechargeandconsumption  tBdRechargeandconsumption = new TBdRechargeandconsumption();
			
			 String location = "http://www.baidu.com";
			 String result = sendGet(location);
			  System.out.println(result);;
			  
			  /*
			   * 测试  设置全为成功
			   */
			  
			  tBdUser =sUserDao.findById(uid);
			  tBdMessagesendgroup.setTBdUser(tBdUser);
			  tBdRechargeandconsumption.setFBeforeConsumpteMoney(tBdUser.getFMoney());
			  tBdRechargeandconsumption.setFBeforeConsumpteNum(tBdUser.getFMessageNumber());
			    result = "成功";
			    if (result.contains("成功")) {
			    	tBdMessagesendgroup.setFGroupType("不加急");
				smsgGroupDao.save(tBdMessagesendgroup);
				
			    }
			    tBdMessagesend.setFMessageStatus("发送成功");
			    tBdMessagesend.setTBdMessagesendgroup(tBdMessagesendgroup);
			    tBdMessagesend.setFSendStatus("已发送");
			    tBdMessagesend.setFSendCostStatus("已计费");
			    String [] phones = tBdMessagesendgroup.getFGroupPhones().split(",");
			    msgSend(phones, tBdUser, tBdMessagesend);
			    //收费
			    tBdUser.setFMoney(tBdUser.getFMoney() - phones.length * price );
			    tBdUser.setFMessageNumber(Math.round((tBdUser.getFMoney() * 1l / price)));
			    sUserDao.update(tBdUser);
			    
			    
			    tBdRechargeandconsumption.setFAfterConsumpteMoney(tBdUser.getFMoney());
			    tBdRechargeandconsumption.setFAfterConsumpteNum(tBdUser.getFMessageNumber());
			    tBdRechargeandconsumption.setFConsumpteMoney(phones.length * price);
			    tBdRechargeandconsumption.setFConsumpteNum(phones.length * 1l);
			    tBdRechargeandconsumption.setFOperateType("消费");
			    tBdRechargeandconsumption.setTBdUser(tBdUser);
			    sRechargeConsumptionDao.save(tBdRechargeandconsumption);
			    
			
		} catch (Exception e) {
		    e.printStackTrace();
			return "fail";
		}
		return "success";
	}
    public  void consume(TBdUser tBdUser,TBdMessagesendgroup tBdMessagesendgroup){
    	
    	
    }
	
	public static String sendGet(String url)
    {
     String result = "";
     try{
      String urlName = url ;

      URL U = new URL(urlName);
      URLConnection connection = U.openConnection();
      connection.connect();
     
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = in.readLine())!= null)
      {
       result += line;
      }
      in.close();   
     }catch(Exception e){
      System.out.println("没有结果！"+e);
     }
     return result;
    }
    
	public  String writeInfo(TBdUser tBdUser ,Long uid){
		try {
			SUserDao sUserDao = new SUserDao();
			TBdUser tBdUser2 = sUserDao.findById(uid);
			tBdUser2.setFUserFullName(tBdUser.getFUserFullName());
			tBdUser2.setFEmail(tBdUser.getFEmail());
			tBdUser2.setFPhoneNumber(tBdUser.getFPhoneNumber());
			tBdUser2.setFUpdateStatus("已修改");
			sUserDao.update(tBdUser2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
		return "success";
		
		
		
	}

	
	
	
	
	public TBdMessagesend gettBdMessagesend() {
		return tBdMessagesend;
	}

	public void settBdMessagesend(TBdMessagesend tBdMessagesend) {
		this.tBdMessagesend = tBdMessagesend;
	}

	public TBdMessagesendgroup gettBdMessagesendgroup() {
		return tBdMessagesendgroup;
	}

	public void settBdMessagesendgroup(TBdMessagesendgroup tBdMessagesendgroup) {
		this.tBdMessagesendgroup = tBdMessagesendgroup;
	}

	public String[] parsePhoneNum(String phone){
		String string = phone;
		/*int count=0;
		while (string.contains(",")) {
			count++;
			string = string.split("")
		}*/
		return phone.split(",");
		
	}
}
