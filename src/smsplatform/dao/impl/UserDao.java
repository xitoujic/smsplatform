package smsplatform.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import smsplatform.dao.TBdUser;

import com.hanphon.recruit.dao.impl.GenericDaoHibernateImpl;
import com.hanphon.recruit.dao.impl.HibernateUtil;
import com.hanphon.recruit.domain.ScoreDomain;

public class UserDao extends GenericDaoHibernateImpl<TBdUser, Long> {
	public List<TBdUser> queryByPage(int pageSize, int pageNow) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			String queryString = "from TBdUser";
			Query queryObject = session.createQuery(queryString);
			queryObject.setFirstResult(pageSize * (pageNow - 1));
			queryObject.setMaxResults(pageSize);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public int totalcount() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			String queryString = "select count(*) from TBdUser";
			Query queryObject = session.createQuery(queryString);
			transaction.commit();
			return ((Long) queryObject.iterate().next()).intValue();
		} catch (RuntimeException re) {

			throw re;
		}

	}

	public Boolean setOnStatus(String id, String status) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Query query = session
					.createQuery("update StudentDomain set onStatus = ? where userId = ?");
			query.setString(0, status);
			query.setString(1, id);

			int rowCount = query.executeUpdate();

			transaction.commit();

			return (rowCount != 0);
		} catch (Exception e) {
			return false;
		}
	}

}
