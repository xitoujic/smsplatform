package smsplatform.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import smsplatform.dao.TBdUser;



public class SUserDao extends GenericDaoHibernateImpl<TBdUser, Long> {
	/*public List<TBdUser> queryByPage(int pageSize, int pageNow) {
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
	}*/

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
	public List findByName(String value) {
		Session session = null;
        try {   session = HibernateUtil.getSession();
                String queryString = "from TBdUser as model where model.FUserName= ?";
                Query queryObject = session.createQuery(queryString);
                queryObject.setParameter(0, value);
                return queryObject.list();
        } catch (RuntimeException re) {
              
                throw re;
        }
}


}
