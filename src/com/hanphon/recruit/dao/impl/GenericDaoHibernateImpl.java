/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName GenericDaoHibernateImpl.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hanphon.recruit.dao.GenericDao;

/**
 * @author soledad pisces
 * 
 */
public class GenericDaoHibernateImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDaoHibernateImpl() {

		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Boolean delete(T entity) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.delete(entity);
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

	@SuppressWarnings("unchecked")
	public T findById(PK id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			return (T) session.get(this.clazz, id);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Boolean save(T entity) {
		Session session = null;
		Transaction transaction = null;
		try {
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

	public Boolean update(T entity) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.update(entity);
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

}
