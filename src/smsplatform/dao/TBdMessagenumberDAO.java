package smsplatform.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBdMessagenumber entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see smsplatform.dao.TBdMessagenumber
 * @author MyEclipse Persistence Tools
 */

public class TBdMessagenumberDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TBdMessagenumberDAO.class);

	// property constants

	public void save(TBdMessagenumber transientInstance) {
		log.debug("saving TBdMessagenumber instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBdMessagenumber persistentInstance) {
		log.debug("deleting TBdMessagenumber instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBdMessagenumber findById(smsplatform.dao.TBdMessagenumberId id) {
		log.debug("getting TBdMessagenumber instance with id: " + id);
		try {
			TBdMessagenumber instance = (TBdMessagenumber) getSession().get(
					"smsplatform.dao.TBdMessagenumber", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBdMessagenumber instance) {
		log.debug("finding TBdMessagenumber instance by example");
		try {
			List results = getSession().createCriteria(
					"smsplatform.dao.TBdMessagenumber").add(
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
		log.debug("finding TBdMessagenumber instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TBdMessagenumber as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TBdMessagenumber instances");
		try {
			String queryString = "from TBdMessagenumber";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBdMessagenumber merge(TBdMessagenumber detachedInstance) {
		log.debug("merging TBdMessagenumber instance");
		try {
			TBdMessagenumber result = (TBdMessagenumber) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBdMessagenumber instance) {
		log.debug("attaching dirty TBdMessagenumber instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBdMessagenumber instance) {
		log.debug("attaching clean TBdMessagenumber instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}