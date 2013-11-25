/**
 *@time 2011-3-18
 *@author soledad pisces
 *@fileName StudentMessageDaoHibernateImpl.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hanphon.recruit.dao.StudentMessageDao;
import com.hanphon.recruit.domain.NoticeDomain;
import com.hanphon.recruit.domain.StudentDomain;

/**
 * @author soledad pisces
 * 
 */
public class StudentMessageDaoHibernateImpl extends
		GenericDaoHibernateImpl<StudentDomain, String> implements
		StudentMessageDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hanphon.recruit.dao.StudentMessageDao#getAll()
	 */
	public List<NoticeDomain> getAll() {
		return null;
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

	@SuppressWarnings("unchecked")
	public String getOnStatus(String id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session
					.createQuery("select onStatus from StudentDomain where userId = ?");
			query.setString(0, id);
			
			List<String> list= query.list();

			return list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hanphon.recruit.dao.StudentMessageDao#getIdByName(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public String getIdByName(String name) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery("select userId from StudentDomain where userName = ?");
			query.setString(0, name);
			
			List<String> list= query.list();

			return list.get(0);
		} catch(Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
