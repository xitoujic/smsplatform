/**
 *@time 2011-3-15
 *@author soledad pisces
 *@fileName GenericDaoHibernateImpl.java
 *@contract jiangguojian1990@qq.com
 */
package smsplatform.dao.impl;

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
/*	
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	protected static <T> String getEntityName(Class<T> clazz){
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name())){
			entityname = entity.name();
		}
		return entityname;
	}*/
	
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
			e.printStackTrace();
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return true;
	}
	
	
	public List  findALLObject(){
		Session session = null;
		Transaction transaction = null;
		try {
		/*	session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			String queryString = "from "+clazz.getName();
			Query queryObject = session.createQuery(queryString);
			queryObject.setFirstResult(pageSize * (pageNow - 1));
			queryObject.setMaxResults(pageSize);
			transaction.commit();
			return queryObject.list();*/
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			System.out.println(clazz.getName());
			String queryString = "from "+clazz.getName();
			Query queryObject = session.createQuery(queryString);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {

			throw re;
		}
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
	public List findByProperty(String propertyName, Object value) {
		Session session = null;
        try {
        	    session = HibernateUtil.getSession();
                String queryString = "from "+clazz.getName()+" as model where model."
                                + propertyName + "= ?";
                Query queryObject = session.createQuery(queryString);
                queryObject.setParameter(0, value);
                return queryObject.list();
        } catch (RuntimeException re) {
               
                throw re;
        }
    }
	public List findByProperty(String propertyName, Object value,String orderBY,boolean ascORdesc) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			String queryString = "from "+clazz.getName()+" as model where model."
			+ propertyName + "= ? order by model."+orderBY+(ascORdesc?" asc":" desc");
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
	
	
	public List<T> queryByPage(int pageSize, int pageNow) {
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
	public List<T> queryByPage(int pageSize, int pageNow,String orderBY,boolean ascORdesc) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			String queryString = "from "+clazz.getName()+" as model order by model."+orderBY+(ascORdesc?" asc":" desc");
			Query queryObject = session.createQuery(queryString);
			queryObject.setFirstResult(pageSize * (pageNow - 1));
			queryObject.setMaxResults(pageSize);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
	public List<T> queryPageByProperty(int pageSize, int pageNow,String orderBY,boolean ascORdesc,String propertyName, Object value) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			String queryString = "from "+clazz.getName()+" as model where model."+propertyName+"=? order by model."+orderBY+(ascORdesc?" asc":" desc");
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setFirstResult(pageSize * (pageNow - 1));
			queryObject.setMaxResults(pageSize);
			transaction.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			
			throw re;
		}
	
	}

	
}
