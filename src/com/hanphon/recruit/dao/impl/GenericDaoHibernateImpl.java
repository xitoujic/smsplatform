/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName GenericDaoHibernateImpl.java
 *@contract jiangguojian1990@qq.com
 */
package com.hanphon.recruit.dao.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import smsplatform.dao.TBdUser;
import smsplatform.util.GenericsUtils;

import com.hanphon.recruit.dao.GenericDao;


/**
 * @author soledad pisces
 * 
 */
public class GenericDaoHibernateImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {
	private Class<T> clazz;
	
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	protected static <T> String getEntityName(Class<T> clazz){
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name())){
			entityname = entity.name();
		}
		return entityname;
	}
	
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
			e.printStackTrace();
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
	
	
	public long findALL(){
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			System.out.println(clazz.getName());
			String queryString = "select count(*) from "+clazz.getName();
			Query queryObject = session.createQuery(queryString);
			transaction.commit();
			return ((Long) queryObject.iterate().next()).intValue();
		} catch (RuntimeException re) {

			throw re;
		}
	}
	
	/*public long getCount() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
		//	String queryString = "from TBdUser";
			Query queryObject =  session.createQuery("select count("+ getCountField(this.entityClass) +") from "+ getEntityName(this.entityClass)+ " o");
			
			transaction.commit();
			return (Long) ((Object) queryObject).getSingleResult();
		} catch (RuntimeException re) {

			throw re;
		}
	//	return (Long)em.createQuery("select count("+ getCountField(this.entityClass) +") from "+ getEntityName(this.entityClass)+ " o").getSingleResult();
	}*/
	

	protected static <E> String getCountField(Class<E> clazz){
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for(PropertyDescriptor propertydesc : propertyDescriptors){
				Method method = propertydesc.getReadMethod();
				if(method!=null && method.isAnnotationPresent(EmbeddedId.class)){					
					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					out = "o."+ propertydesc.getName()+ "." + (!ps[1].getName().equals("class")? ps[1].getName(): ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return out;
	}
	
	public List<TBdUser> queryByPage(int pageSize, int pageNow) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			String queryString = "from "+clazz.getName();
			Query queryObject = session.createQuery(queryString);
			queryObject.setFirstResult(pageSize * (pageNow - 1));
			queryObject.setMaxResults(pageSize);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}
	}
}
