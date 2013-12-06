package smsplatform.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import smsplatform.dao.impl.BaseHibernateDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBdRechargeandconsumption entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see smsplatform.dao.TBdRechargeandconsumption
 * @author MyEclipse Persistence Tools
 */

public class TBdRechargeandconsumptionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TBdRechargeandconsumptionDAO.class);
	// property constants
	public static final String _FBEFORE_RECHARGE_MONEY = "FBeforeRechargeMoney";
	public static final String _FRECHARGE_MONEY = "FRechargeMoney";
	public static final String _FAFTER_RECHARGE_MONEY = "FAfterRechargeMoney";
	public static final String _FBEFORE_RECHARGE_NUM = "FBeforeRechargeNum";
	public static final String _FRECHARGE_NUM = "FRechargeNum";
	public static final String _FAFTER_RECHARGE_NUM = "FAfterRechargeNum";
	public static final String _FBEFORE_CONSUMPTE_MONEY = "FBeforeConsumpteMoney";
	public static final String _FCONSUMPTE_MONEY = "FConsumpteMoney";
	public static final String _FAFTER_CONSUMPTE_MONEY = "FAfterConsumpteMoney";
	public static final String _FBEFORE_CONSUMPTE_NUM = "FBeforeConsumpteNum";
	public static final String _FCONSUMPTE_NUM = "FConsumpteNum";
	public static final String _FAFTER_CONSUMPTE_NUM = "FAfterConsumpteNum";
	public static final String _FOPERATE_TYPE = "FOperateType";

	public void save(TBdRechargeandconsumption transientInstance) {
		log.debug("saving TBdRechargeandconsumption instance");
		 Transaction transaction = null;
		try {
			transaction = getSession().beginTransaction();
			getSession().save(transientInstance);
			 transaction.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			 transaction.rollback();
			throw re;
		}
	}

	public void delete(TBdRechargeandconsumption persistentInstance) {
		log.debug("deleting TBdRechargeandconsumption instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBdRechargeandconsumption findById(java.lang.Long id) {
		log.debug("getting TBdRechargeandconsumption instance with id: " + id);
		try {
			TBdRechargeandconsumption instance = (TBdRechargeandconsumption) getSession()
					.get("smsplatform.dao.TBdRechargeandconsumption", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBdRechargeandconsumption instance) {
		log.debug("finding TBdRechargeandconsumption instance by example");
		try {
			List results = getSession().createCriteria(
					"smsplatform.dao.TBdRechargeandconsumption").add(
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
		log.debug("finding TBdRechargeandconsumption instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TBdRechargeandconsumption as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFBeforeRechargeMoney(Object FBeforeRechargeMoney) {
		return findByProperty(_FBEFORE_RECHARGE_MONEY, FBeforeRechargeMoney);
	}

	public List findByFRechargeMoney(Object FRechargeMoney) {
		return findByProperty(_FRECHARGE_MONEY, FRechargeMoney);
	}

	public List findByFAfterRechargeMoney(Object FAfterRechargeMoney) {
		return findByProperty(_FAFTER_RECHARGE_MONEY, FAfterRechargeMoney);
	}

	public List findByFBeforeRechargeNum(Object FBeforeRechargeNum) {
		return findByProperty(_FBEFORE_RECHARGE_NUM, FBeforeRechargeNum);
	}

	public List findByFRechargeNum(Object FRechargeNum) {
		return findByProperty(_FRECHARGE_NUM, FRechargeNum);
	}

	public List findByFAfterRechargeNum(Object FAfterRechargeNum) {
		return findByProperty(_FAFTER_RECHARGE_NUM, FAfterRechargeNum);
	}

	public List findByFBeforeConsumpteMoney(Object FBeforeConsumpteMoney) {
		return findByProperty(_FBEFORE_CONSUMPTE_MONEY, FBeforeConsumpteMoney);
	}

	public List findByFConsumpteMoney(Object FConsumpteMoney) {
		return findByProperty(_FCONSUMPTE_MONEY, FConsumpteMoney);
	}

	public List findByFAfterConsumpteMoney(Object FAfterConsumpteMoney) {
		return findByProperty(_FAFTER_CONSUMPTE_MONEY, FAfterConsumpteMoney);
	}

	public List findByFBeforeConsumpteNum(Object FBeforeConsumpteNum) {
		return findByProperty(_FBEFORE_CONSUMPTE_NUM, FBeforeConsumpteNum);
	}

	public List findByFConsumpteNum(Object FConsumpteNum) {
		return findByProperty(_FCONSUMPTE_NUM, FConsumpteNum);
	}

	public List findByFAfterConsumpteNum(Object FAfterConsumpteNum) {
		return findByProperty(_FAFTER_CONSUMPTE_NUM, FAfterConsumpteNum);
	}

	public List findByFOperateType(Object FOperateType) {
		return findByProperty(_FOPERATE_TYPE, FOperateType);
	}

	public List findAll() {
		log.debug("finding all TBdRechargeandconsumption instances");
		try {
			String queryString = "from TBdRechargeandconsumption";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBdRechargeandconsumption merge(
			TBdRechargeandconsumption detachedInstance) {
		log.debug("merging TBdRechargeandconsumption instance");
		try {
			TBdRechargeandconsumption result = (TBdRechargeandconsumption) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBdRechargeandconsumption instance) {
		log.debug("attaching dirty TBdRechargeandconsumption instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBdRechargeandconsumption instance) {
		log.debug("attaching clean TBdRechargeandconsumption instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public TBdRechargeandconsumption findLastResultById(java.lang.Long id) {
		log.debug("getting TBdRechargeandconsumption instance with id: " + id);
		try {
			String queryString = "from TBdRechargeandconsumption  as model where model.TBdUser.FUserId= ?" +"order by model.FRcgAndCuptId desc";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, id);
			queryObject.setMaxResults(1).uniqueResult();
			
			return  (queryObject.list().size()>0?(TBdRechargeandconsumption)queryObject.list().get(0):null);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}