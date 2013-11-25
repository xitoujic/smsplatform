/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName RegisterMessageDaoHibernateImpl.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.hanphon.recruit.dao.RegisterMessageDao;
import com.hanphon.recruit.domain.RegisterMessageDomain;

/**
 * @author soledad pisces
 * 
 */
public class RegisterMessageDaoHibernateImpl extends
		GenericDaoHibernateImpl<RegisterMessageDomain, String> implements
		RegisterMessageDao<RegisterMessageDomain, String> {
	public Boolean save(RegisterMessageDomain entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			if(findByEmail(entity.getUserEmail()) != null){
				return false;
			}
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch (Exception e) {
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;

	}

	public String[] findByEmail(String email) {
		Session session = null;

		if (email == null) {
			return null;
		}

		try {
			session = HibernateUtil.getSession();
			Criteria criteria = session
					.createCriteria(RegisterMessageDomain.class);
			criteria.add(Restrictions.eq("userEmail", email));
			criteria.list();
			RegisterMessageDomain domain = null;
			domain = (RegisterMessageDomain) criteria.uniqueResult();

			String[] retVal = { domain.getUserPassword(),
					domain.getIsStudent(), domain.getUserId() };

			return retVal;
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
