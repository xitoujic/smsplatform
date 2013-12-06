package smsplatform.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smsplatform.dao.impl.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBdLog entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see smsplatform.dao.TBdLog
 * @author MyEclipse Persistence Tools
 */

public class TBdLogDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TBdLogDAO.class);
	// property constants
	public static final String _FBEFOR = "FBefor";
	public static final String _FOPERATE = "FOperate";
	public static final String _FAFTER = "FAfter";

	public void save(TBdLog transientInstance) {
		log.debug("saving TBdLog instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBdLog persistentInstance) {
		log.debug("deleting TBdLog instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBdLog findById(java.lang.Long id) {
		log.debug("getting TBdLog instance with id: " + id);
		try {
			TBdLog instance = (TBdLog) getSession().get(
					"smsplatform.dao.TBdLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBdLog instance) {
		log.debug("finding TBdLog instance by example");
		try {
			List results = getSession()
					.createCriteria("smsplatform.dao.TBdLog").add(
							Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TBdLog instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TBdLog as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFBefor(Object FBefor) {
		return findByProperty(_FBEFOR, FBefor);
	}

	public List findByFOperate(Object FOperate) {
		return findByProperty(_FOPERATE, FOperate);
	}

	public List findByFAfter(Object FAfter) {
		return findByProperty(_FAFTER, FAfter);
	}

	public List findAll() {
		log.debug("finding all TBdLog instances");
		try {
			String queryString = "from TBdLog";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBdLog merge(TBdLog detachedInstance) {
		log.debug("merging TBdLog instance");
		try {
			TBdLog result = (TBdLog) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBdLog instance) {
		log.debug("attaching dirty TBdLog instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBdLog instance) {
		log.debug("attaching clean TBdLog instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}