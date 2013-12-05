package smsplatform.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdUser;

import com.hanphon.recruit.dao.impl.GenericDaoHibernateImpl;
import com.hanphon.recruit.dao.impl.HibernateUtil;
import com.hanphon.recruit.domain.ScoreDomain;

public class SRechargeConsumptionDao extends
		GenericDaoHibernateImpl<TBdRechargeandconsumption, Long> {
	public TBdRechargeandconsumption findLastResultById(java.lang.Long id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			String queryString = "from TBdRechargeandconsumption  as model where model.TBdUser.FUserId= ?"
					+ "order by model.FRcgAndCuptId desc";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, id);
			queryObject.setMaxResults(1).uniqueResult();

			return (queryObject.list().size() > 0 ? (TBdRechargeandconsumption) queryObject
					.list().get(0)
					: null);
		} catch (RuntimeException re) {

			throw re;
		}
	}

}
