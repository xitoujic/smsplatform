package smsplatform.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBdMessagesend entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see smsplatform.dao.TBdMessagesend
 * @author MyEclipse Persistence Tools
 */

public class TBdMessagesendDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TBdMessagesendDAO.class);
	// property constants
	public static final String _FSEND_NUMBER = "FSendNumber";
	public static final String _FSEND_STATUS = "FSendStatus";
	public static final String _FSEND_COST_STATUS = "FSendCostStatus";
	public static final String _FMESSAGE_STATUS = "FMessageStatus";
	public static final String _FOPERATOR = "FOperator";
	public static final String _FNUMBER_AREA = "FNumberArea";

	public void save(TBdMessagesend transientInstance) {
		log.debug("saving TBdMessagesend instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBdMessagesend persistentInstance) {
		log.debug("deleting TBdMessagesend instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBdMessagesend findById(java.lang.Long id) {
		log.debug("getting TBdMessagesend instance with id: " + id);
		try {
			TBdMessagesend instance = (TBdMessagesend) getSession().get(
					"smsplatform.dao.TBdMessagesend", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBdMessagesend instance) {
		log.debug("finding TBdMessagesend instance by example");
		try {
			List results = getSession().createCriteria(
					"smsplatform.dao.TBdMessagesend").add(
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
		log.debug("finding TBdMessagesend instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TBdMessagesend as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFSendNumber(Object FSendNumber) {
		return findByProperty(_FSEND_NUMBER, FSendNumber);
	}

	public List findByFSendStatus(Object FSendStatus) {
		return findByProperty(_FSEND_STATUS, FSendStatus);
	}

	public List findByFSendCostStatus(Object FSendCostStatus) {
		return findByProperty(_FSEND_COST_STATUS, FSendCostStatus);
	}

	public List findByFMessageStatus(Object FMessageStatus) {
		return findByProperty(_FMESSAGE_STATUS, FMessageStatus);
	}

	public List findByFOperator(Object FOperator) {
		return findByProperty(_FOPERATOR, FOperator);
	}

	public List findByFNumberArea(Object FNumberArea) {
		return findByProperty(_FNUMBER_AREA, FNumberArea);
	}

	public List findAll() {
		log.debug("finding all TBdMessagesend instances");
		try {
			String queryString = "from TBdMessagesend";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBdMessagesend merge(TBdMessagesend detachedInstance) {
		log.debug("merging TBdMessagesend instance");
		try {
			TBdMessagesend result = (TBdMessagesend) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBdMessagesend instance) {
		log.debug("attaching dirty TBdMessagesend instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBdMessagesend instance) {
		log.debug("attaching clean TBdMessagesend instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}