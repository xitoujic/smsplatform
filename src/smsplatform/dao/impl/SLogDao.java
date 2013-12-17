package smsplatform.dao.impl;

import com.sun.org.apache.commons.collections.StaticBucketMap;

import smsplatform.dao.TBdLog;
import smsplatform.dao.TBdUser;



public class SLogDao  extends
  GenericDaoHibernateImpl<TBdLog, Long>{
   public static SLogDao instance = null;
   public static SLogDao getInstance(){
	   if (instance == null) {
		instance = new SLogDao();
		System.out.println("log初始化========");
	} else {
       System.out.println("log 单例---");
	}
	   return instance;
   }
}
